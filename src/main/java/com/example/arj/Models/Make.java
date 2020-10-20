package com.example.arj.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Make")
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "make")
    @JsonIgnoreProperties(value = {"make", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ItemMRMapping> itemMRMappings;

    @Column(nullable = false)
    private boolean isValid = true;

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

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Make() {
    }

    public Make(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Make{" +
                "id=" + id +
//                ", itemMRMappings=" + itemMRMappings +
                ", isValid=" + isValid +
                ", value='" + value + '\'' +
                '}';
    }
}
