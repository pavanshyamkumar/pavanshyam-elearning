package com.project.HealthCare.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Students {

    @Id
    private Long stuid;

    private String name;

    private String email;

    private String college;

    private String degree;

    private String year;

    @OneToMany(mappedBy = "students",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private Set<Results> results=new LinkedHashSet<>();

    public Students() {
    }

    

    public Students(Long stuid, String name, String email, String college, String degree, String year) {
        this.stuid = stuid;
        this.name = name;
        this.email = email;
        this.college = college;
        this.degree = degree;
        this.year = year;
    }

    

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public Long getStuid() {
        return stuid;
    }

    public void setStuid(Long stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



    public Set<Results> getResults() {
        return results;
    }



    public void setResults(Set<Results> results) {
        this.results = results;
    }


    

    
}
