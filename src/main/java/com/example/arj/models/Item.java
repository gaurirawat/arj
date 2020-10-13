package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="uomId")
    @JsonIgnoreProperties(value = {"items", "hibernateLazyInitializer"}, allowSetters = true)
    private UOM uom;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="serviceId")
    @JsonIgnoreProperties(value = {"items", "hibernateLazyInitializer"}, allowSetters = true)
    private Service service;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    @JsonIgnoreProperties(value = {"item", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ItemMRMapping> itemMRMappings;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isActive=true;
}
