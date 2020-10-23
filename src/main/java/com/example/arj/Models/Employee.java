package com.example.arj.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Employee")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "positionId")
    @JsonIgnoreProperties(value = {"employees", "transactions","hibernateLazyInitializer"}, allowSetters = true)
    private Position position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    @JsonIgnoreProperties(value = {"levelOfHierarchy", "employee", "materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "raisedBy")
    @JsonIgnoreProperties(value = {"raisedBy", "project", "transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private List<MaterialRequest> materialRequests;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pe")
//    @JsonIgnoreProperties(value={"pe", "hibernateLazyInitializer"}, allowSetters = true)
//    private List<ProjectPEMapping> projectPEMappings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
    @JsonIgnoreProperties(value = {"manager","pes","materialRequests","hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> pmProjects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pes")
    @JsonIgnoreProperties(value = {"pes","manager", "materialRequests","hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> peProjects;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<MaterialRequest> getMaterialRequests() {
        return materialRequests;
    }

    public void setMaterialRequests(List<MaterialRequest> materialRequests) {
        this.materialRequests = materialRequests;
    }

    public List<Project> getPmProjects() {
        return pmProjects;
    }

    public void setPmProjects(List<Project> pmProjects) {
        this.pmProjects = pmProjects;
    }

    public List<Project> getPeProjects() {
        return peProjects;
    }

    public void setPeProjects(List<Project> peProjects) {
        this.peProjects = peProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee() {
    }

}
