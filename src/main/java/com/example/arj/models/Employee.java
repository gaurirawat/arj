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
    private Integer id;

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

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pe")
//    @JsonIgnoreProperties(value={"pe", "hibernateLazyInitializer"}, allowSetters = true)
//    private List<ProjectPEMapping> projectPEMappings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
    @JsonIgnoreProperties(value={"manager", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> PMProjects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pes")
    @JsonIgnoreProperties(value={"pes", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> PEProjects;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive =true;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Employee() {
    }

}
