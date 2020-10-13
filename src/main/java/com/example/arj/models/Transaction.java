//should we use timestamp or date?



package com.example.arj.models;

import com.example.arj.utils.ActionEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@JsonRootName("Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="employeeId")
    @JsonIgnoreProperties(value={"transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "materialRequestId")
    @JsonIgnoreProperties(value= {"transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private MaterialRequest materialRequest;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="levelOfHierarchy")
    @JsonIgnoreProperties(value= {"transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private Position position;

    @Column(nullable = false, updatable = false)
    private Timestamp timestamp= new Timestamp(System.currentTimeMillis());

    @Column(nullable = false, updatable = false)
    private ActionEnum action;


}
