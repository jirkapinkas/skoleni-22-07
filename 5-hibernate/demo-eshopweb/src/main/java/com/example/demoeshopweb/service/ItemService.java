package com.example.demoeshopweb.service;

import com.example.demoeshopweb.dto.ItemDto;
import com.example.demoeshopweb.entity.Item;
import com.example.demoeshopweb.mapper.ItemMapper;
import com.example.demoeshopweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public List<ItemDto> findAll() {
        return itemMapper.toDto(itemRepository.findAll());
    }

    public Optional<ItemDto> findById(int id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDto);
    }

}
