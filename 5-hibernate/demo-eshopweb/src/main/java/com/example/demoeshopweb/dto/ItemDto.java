package com.example.demoeshopweb.dto;

import lombok.Getter;
import lombok.Setter;

public record ItemDto(
        int id,
        String name,
        String description,
        double price
) {
}

//@Getter
//@Setter
//public class ItemDto {
//    private int id;
//    private String name;
//    private double price;
//}