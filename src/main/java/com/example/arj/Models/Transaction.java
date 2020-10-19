//should we use timestamp or date?


package com.example.arj.Models;

import com.example.arj.utils.ActionEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonRootName("Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeeId")
    @JsonIgnoreProperties(value = {"transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "materialRequestId")
    @JsonIgnoreProperties(value = {"transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private MaterialRequest materialRequest;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "levelOfHierarchyId")
    @JsonIgnoreProperties(value = {"transactions", "hibernateLazyInitializer"}, allowSetters = true)
    private Position levelOfHierarchy;

    @Column(nullable = false, updatable = false)
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Column(nullable = false, updatable = false)
    private ActionEnum action;

    @Column(nullable = false)
    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MaterialRequest getMaterialRequest() {
        return materialRequest;
    }

    public void setMaterialRequest(MaterialRequest materialRequest) {
        this.materialRequest = materialRequest;
    }

    public Position getLevelOfHierarchy() {
        return levelOfHierarchy;
    }

    public void setLevelOfHierarchy(Position levelOfHierarchy) {
        this.levelOfHierarchy = levelOfHierarchy;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Transaction() {
    }
}
