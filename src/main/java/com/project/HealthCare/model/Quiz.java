package com.project.HealthCare.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;

    private String title;

    private String description;

    private String maxMarks;

    private String numberofQuestions;

    private boolean active=false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Courses courses;

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private Set<Question> questions=new HashSet<>();

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private Set<Results> results=new LinkedHashSet<>();

    public Quiz(){
        
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Long getqId() {
        return qId;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getNumberofQuestions() {
        return numberofQuestions;
    }

    public void setNumberofQuestions(String numberofQuestions) {
        this.numberofQuestions = numberofQuestions;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Set<Results> getResults() {
        return results;
    }

    public void setResults(Set<Results> results) {
        this.results = results;
    }

    

    
    
}
