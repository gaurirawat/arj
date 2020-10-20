package com.example.arj.Models;

import com.example.arj.Utils.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonRootName("MaterialRequest")
public class MaterialRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "serviceId")
    @JsonIgnoreProperties(value = {"materialRequests", "hibernateLazyInitializer"}, allowSetters = true)
    private Service service;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projectId")
    @JsonIgnoreProperties(value = {"materialRequests", "hibernateLazyInitializer"}, allowSetters = true)
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "raisedById")
    @JsonIgnoreProperties(value = {"materialRequests", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee raisedBy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialRequest")
    @JsonIgnoreProperties(value = {"materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialRequest")
    @JsonIgnoreProperties(value = {"materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    private List<PurchaseOrder> purchaseOrders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialRequest")
    @JsonIgnoreProperties(value = {"materialRequest", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ItemMRMapping> itemMRMappings;

    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCreation = Date.valueOf(LocalDate.now());

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCancellation;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doRequiredDelivery;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date doCompletion;

    @Column(nullable = false)
    private StatusEnum status = StatusEnum.PENDING;

    private String remark;
    private String areaFloor;
    private String instruction;

    private int currentLevelOfHierarchy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(Employee raisedBy) {
        this.raisedBy = raisedBy;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public List<ItemMRMapping> getItemMRMappings() {
        return itemMRMappings;
    }

    public void setItemMRMappings(List<ItemMRMapping> itemMRMappings) {
        this.itemMRMappings = itemMRMappings;
    }

    public Date getDoCreation() {
        return doCreation;
    }

    public void setDoCreation(Date doCreation) {
        this.doCreation = doCreation;
    }

    public Date getDoCancellation() {
        return doCancellation;
    }

    public void setDoCancellation(Date doCancellation) {
        this.doCancellation = doCancellation;
    }

    public Date getDoRequiredDelivery() {
        return doRequiredDelivery;
    }

    public void setDoRequiredDelivery(Date doRequiredDelivery) {
        this.doRequiredDelivery = doRequiredDelivery;
    }

    public Date getDoCompletion() {
        return doCompletion;
    }

    public void setDoCompletion(Date doCompletion) {
        this.doCompletion = doCompletion;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAreaFloor() {
        return areaFloor;
    }

    public void setAreaFloor(String areaFloor) {
        this.areaFloor = areaFloor;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getCurrentLevelOfHierarchy() {
        return currentLevelOfHierarchy;
    }

    public void setCurrentLevelOfHierarchy(int currentLevelOfHierarchy) {
        this.currentLevelOfHierarchy = currentLevelOfHierarchy;
    }

    public MaterialRequest() {
    }
}
