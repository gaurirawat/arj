package com.example.arj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity(name = "project_pe_mapping")
@JsonRootName("ProjectPEMapping")
public class ProjectPEMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "projectId")
//    @JsonIgnoreProperties(value={"projectPEMappings", "hibernateLazyInitializer"}, allowSetters = true)
//    private Project project;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "peId")
//    @JsonIgnoreProperties(value={"projectPEMappings", "hibernateLazyInitializer"}, allowSetters = true)
//    private Employee pe;

}
