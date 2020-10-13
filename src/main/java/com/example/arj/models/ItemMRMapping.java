package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity
@JsonRootName("ItemMRMapping")
public class ItemMRMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="materialRequestId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private MaterialRequest materialRequest;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="itemId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="makeId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private Make make;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="originId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private Origin origin;

    @Column(nullable = false)
    private int quantity;
}
