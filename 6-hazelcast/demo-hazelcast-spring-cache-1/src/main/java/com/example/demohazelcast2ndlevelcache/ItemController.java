package com.example.demohazelcast2ndlevelcache;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemRepository itemRepository;

    @Cacheable("items")
    @GetMapping("/")
    public List<Item> item() {
        return itemRepository.findAll();
    }

//    @GetMapping("/")
//    public Optional<Item> item() {
//        return itemRepository.findById(1L);
//    }

}
