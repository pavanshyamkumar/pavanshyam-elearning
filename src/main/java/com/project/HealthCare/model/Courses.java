package com.project.HealthCare.model;

import java.util.LinkedHashSet;
import java.util.Set;


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
@Table(name = "course")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    private String cname;

    private String description;

    private boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Professors professors;

    @OneToMany(mappedBy = "courses", fetch = FetchType.EAGER,  orphanRemoval = true)
    @JsonIgnore
    private Set<Lessions> lessions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "courses", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private Set<Quiz> quizes = new LinkedHashSet<>();

    public Professors getProfessors() {
        return professors;
    }

    public void setProfessors(Professors professors) {
        this.professors = professors;
    }

    public Set<Lessions> getLessions() {
        return lessions;
    }

    public void setLessions(Set<Lessions> lessions) {
        this.lessions = lessions;
    }

    public Courses() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Courses(Long cid, String cname, String description, boolean active, Set<Lessions> lessions) {
        this.cid = cid;
        this.cname = cname;
        this.description = description;
        this.active = active;
        this.lessions = lessions;
    }

}
