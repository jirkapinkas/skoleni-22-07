package com.example.demoeshopweb.controller;

import com.example.demoeshopweb.dto.ItemDto;
import com.example.demoeshopweb.entity.Item;
import com.example.demoeshopweb.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> items() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItemDto> item(@PathVariable int id) {
        return itemService.findById(id);
    }

}
