package com.project.HealthCare.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lession")
public class Lessions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lid;
    private String lname;

    @ManyToOne(fetch = FetchType.EAGER)
    private Courses courses;

    @OneToMany(mappedBy = "lessions",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private Set<Content> content =new LinkedHashSet<>();
    
    public Lessions() {
    }


    public Lessions(String lname) {
        this.lname = lname;
    }


    public Long getLid() {
        return lid;
    }


    public void setLid(Long lid) {
        this.lid = lid;
    }


    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }


    public Courses getCourses() {
        return courses;
    }


    public void setCourses(Courses courses) {
        this.courses = courses;
    }


    


    
    


    
}
