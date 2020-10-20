package com.example.arj.Models;

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
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "positionId")
    @JsonIgnoreProperties(value = {"employees", "hibernateLazyInitializer"}, allowSetters = true)
    private Position position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "raisedBy")
    @JsonIgnoreProperties(value = {"raisedBy", "hibernateLazyInitializer"}, allowSetters = true)
    private List<MaterialRequest> materialRequests;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pe")
//    @JsonIgnoreProperties(value={"pe", "hibernateLazyInitializer"}, allowSetters = true)
//    private List<ProjectPEMapping> projectPEMappings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
    @JsonIgnoreProperties(value = {"manager", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> PMProjects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pes")
    @JsonIgnoreProperties(value = {"pes", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> PEProjects;

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

    public List<Project> getPMProjects() {
        return PMProjects;
    }

    public void setPMProjects(List<Project> PMProjects) {
        this.PMProjects = PMProjects;
    }

    public List<Project> getPEProjects() {
        return PEProjects;
    }

    public void setPEProjects(List<Project> PEProjects) {
        this.PEProjects = PEProjects;
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