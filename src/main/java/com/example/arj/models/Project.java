package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "managerId")
    @JsonIgnoreProperties(value = {"PMProjects", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee manager;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "project_pe_mapping", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "employeeId"))
    @JsonIgnoreProperties(value = {"PEProjects", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Employee> pes;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
//    @JsonIgnoreProperties(value={"project", "hibernateLazyInitializer"}, allowSetters = true)
//    private List<ProjectPEMapping> projectPEMappings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    @JsonIgnoreProperties(value = {"project", "hibernateLazyInitializer"}, allowSetters = true)
    private List<MaterialRequest> materialRequests;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getPes() {
        return pes;
    }

    public void setPes(List<Employee> pes) {
        this.pes = pes;
    }

    public List<MaterialRequest> getMaterialRequests() {
        return materialRequests;
    }

    public void setMaterialRequests(List<MaterialRequest> materialRequests) {
        this.materialRequests = materialRequests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Project() {
    }
}
