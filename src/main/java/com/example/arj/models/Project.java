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
    @Column(unique=true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "managerId")
    @JsonIgnoreProperties(value={"projects", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee manager;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    @JsonIgnoreProperties(value={"project", "hibernateLazyInitializer"}, allowSetters = true)
    private List<ProjectPEMapping> projectPEMappings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    @JsonIgnoreProperties(value={"project", "hibernateLazyInitializer"}, allowSetters = true)
    private List<MaterialRequest> materialRequests;

}
