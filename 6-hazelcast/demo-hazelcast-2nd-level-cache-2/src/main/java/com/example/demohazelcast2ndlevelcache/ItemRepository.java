package com.example.demohazelcast2ndlevelcache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Item> findAll();
}
