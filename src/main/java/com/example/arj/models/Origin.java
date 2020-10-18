package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Origin")
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, updatable = false)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "origin")
    @JsonIgnoreProperties(value = {"origin", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ItemMRMapping> itemMRMappings;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemMRMapping> getItemMRMappings() {
        return itemMRMappings;
    }

    public void setItemMRMappings(List<ItemMRMapping> itemMRMappings) {
        this.itemMRMappings = itemMRMappings;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Origin() {
    }
}
