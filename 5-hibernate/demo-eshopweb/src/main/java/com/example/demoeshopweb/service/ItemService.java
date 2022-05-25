package com.example.demoeshopweb.service;

import com.example.demoeshopweb.dto.ItemDto;
import com.example.demoeshopweb.entity.Item;
import com.example.demoeshopweb.mapper.ItemMapper;
import com.example.demoeshopweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    @Transactional(readOnly = true)
    public List<ItemDto> findAll() {
//        return itemMapper.toDto(itemRepository.findAllFetchCategories());
        return itemMapper.toDto(itemRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<ItemDto> findById(int id) {
//        return itemRepository.findByIdFetchCategory(id)
//                .map(itemMapper::toDto);
        return itemRepository.findById(id)
                .map(itemMapper::toDto);
    }

}
