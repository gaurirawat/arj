package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, updatable = false)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "service")
    @JsonIgnoreProperties(value = {"service", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "service")
    @JsonIgnoreProperties(value = {"service", "hibernateLazyInitializer"}, allowSetters = true)
    private List<MaterialRequest> materialRequests;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;
}
