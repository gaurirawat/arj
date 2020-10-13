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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialRequest")
    @JsonIgnoreProperties(value = {"materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    List<Transaction> transactions;

    @Column(nullable = false)
    private String materialRequestId;

    @Column(nullable = false)
    private StatusEnum status=StatusEnum.PENDING;

    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCreation=Date.valueOf(LocalDate.now());

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCancellation;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doRequiredDelivery;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCompletion;

    private String remark;
    private String area;
    private String instruction;

    private int currentLevelInHierarchy;

}
