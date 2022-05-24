package com.example.demoeshopweb.mapper;

import com.example.demoeshopweb.dto.ItemDto;
import com.example.demoeshopweb.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ItemDto dto);
    List<Item> toEntity(List<ItemDto> dtos);

    ItemDto toDto(Item entity);
    List<ItemDto> toDto(List<Item> entities);

}
