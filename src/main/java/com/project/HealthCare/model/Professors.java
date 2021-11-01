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
@Table(name = "professor")
public class Professors {

    @Id
    private Long proid;

    private String name;

    private String email;

    private String qualification;

    private String degree;

    private String college;

    private String Phonenumber;

    @OneToMany(mappedBy = "professors",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private Set<Courses> courses=new LinkedHashSet<>();

    public Professors() {
    }

   

    



    






    public Professors(Long proid, String name, String email, String qualification, String degree, String college,
            String phonenumber, Set<Courses> courses) {
        this.proid = proid;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.degree = degree;
        this.college = college;
        Phonenumber = phonenumber;
        this.courses = courses;
    }














    public String getPhonenumber() {
        return Phonenumber;
    }














    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }














    public String getEmail() {
        return email;
    }







    public void setEmail(String email) {
        this.email = email;
    }







    public Set<Courses> getCourses() {
        return courses;
    }



    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }



    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    



    
}
