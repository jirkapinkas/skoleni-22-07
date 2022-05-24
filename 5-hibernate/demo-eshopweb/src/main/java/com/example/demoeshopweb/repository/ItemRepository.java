package com.example.demoeshopweb.repository;

import com.example.demoeshopweb.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
