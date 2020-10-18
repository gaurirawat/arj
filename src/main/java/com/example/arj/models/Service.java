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
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<MaterialRequest> getMaterialRequests() {
        return materialRequests;
    }

    public void setMaterialRequests(List<MaterialRequest> materialRequests) {
        this.materialRequests = materialRequests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Service() {
    }
}
