package com.example.arj.models;

import com.example.arj.utils.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonRootName("MaterialRequest")
public class MaterialRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="serviceId")
    @JsonIgnoreProperties(value = {"materialRequests", "hibernateLazyInitializer"}, allowSetters = true)
    private Service service;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="projectId")
    @JsonIgnoreProperties(value = {"materialRequests", "hibernateLazyInitializer"}, allowSetters = true)
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="raisedById")
    @JsonIgnoreProperties(value = {"materialRequests", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee raisedBy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialRequest")
    @JsonIgnoreProperties(value = {"materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialRequest")
    @JsonIgnoreProperties(value = {"materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ItemMRMapping> itemMRMappings;

    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCreation=Date.valueOf(LocalDate.now());

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCancellation;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doRequiredDelivery;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCompletion;

    @Column(nullable = false)
    private StatusEnum status=StatusEnum.PENDING;

    private String remark;
    private String areaFloor;
    private String instruction;

    private int currentLevelInHierarchy;

}
