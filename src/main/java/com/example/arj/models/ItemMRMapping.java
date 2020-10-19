package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity(name = "item_mr_mapping")
@JsonRootName("ItemMRMapping")
public class ItemMRMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "materialRequestId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private MaterialRequest materialRequest;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "itemId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "makeId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private Make make;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "originId")
    @JsonIgnoreProperties(value = {"itemMRMappings", "hibernateLazyInitializer"}, allowSetters = true)
    private Origin origin;

    @Column(nullable = false)
    private int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MaterialRequest getMaterialRequest() {
        return materialRequest;
    }

    public void setMaterialRequest(MaterialRequest materialRequest) {
        this.materialRequest = materialRequest;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemMRMapping() {
    }
}
