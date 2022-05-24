package com.example.demoeshopweb.repository;

import com.example.demoeshopweb.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    // operace JpaRepository:
    // findXXX() operace nad sebou maji automaticky @Transactional(readOnly = true)
    // save / delete apod. operace nad sebou maji automaticky @Transactional

    // automaticky generovane telo operace
    // vsechny findByXXX() operace nad sebou maji automaticky @Transactional(readOnly = true)
    List<Item> findByName(String name);
    List<Item> findByName(String name, Sort sort);
    List<Item> findByNameOrderById(String name);
    Page<Item> findByName(String name, Pageable pageable);

    // pro cokoli slozitejsiho: @Query, kde je HQL / JPQL
    // tady je jedno jak se ta metoda jmenuje
    @Transactional(readOnly = true)
    @Query("select i from Item i where lower(i.name) like lower(?1)")
    List<Item> findItems(String namePart); // itemRepository.findItems("%java%")

    @Transactional(readOnly = true)
    @Query("select i from Item i where lower(i.name) like lower(:namePart)")
    List<Item> findItems2(@Param("namePart") String namePart); // itemRepository.findItems("%java%")

    @Transactional
    @Modifying
    @Query("update Item i set i.price = i.price * ?1") // ~ update item set price = price * ?1
    void increasePrices(double increase);

    // SQL:
    @Query(nativeQuery = true, value = "select count(*) from item")
    long countItems();

    // Pro dynamictejsi selecty je mozne pouzit:
    // A) JPA Criteria API
    // B) QueryDSL

}
