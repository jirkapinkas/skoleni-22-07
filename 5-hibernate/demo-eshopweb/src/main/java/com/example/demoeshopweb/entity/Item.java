package com.example.demoeshopweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NamedEntityGraph(
        name = Item.ENTITY_GRAPH_ITEM_CATEGORY,
        attributeNodes = @NamedAttributeNode("category")
)
public class Item {

    public static final String ENTITY_GRAPH_ITEM_CATEGORY = "graph.Item.category";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    private String name;

    private String description;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
