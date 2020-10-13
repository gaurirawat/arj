package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;


import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="positionId")
    @JsonIgnoreProperties(value={"employees", "hibernateLazyInitializer"}, allowSetters = true)
    private Position position;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "raisedBy")
    @JsonIgnoreProperties(value={"raisedBy", "hibernateLazyInitializer"}, allowSetters = true)
    private List<MaterialRequest> materialRequests;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pe")
    @JsonIgnoreProperties(value={"pe", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ProjectPEMapping> projectPEMappings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
    @JsonIgnoreProperties(value={"manager", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> projects;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive =true;

}
