package com.project.HealthCare.Services.impl;



import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Repository.CoursesRepo;
import com.project.HealthCare.Services.CourseService;
import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Professors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    public CoursesRepo repo;

    @Override
    public Courses addcourse(Courses course) {

       
        return this.repo.save(course);
    }

    @Override
    public Courses updatecourses(Courses course) {
      
        return this.repo.save(course);
    }

    @Override
    public Set<Courses> getall() {
        
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public Courses getcourse(Long cid) {
     
        return this.repo.findById(cid).orElse(null);
    }

    @Override
    public void del(Long cid) {
        Courses course=new Courses();
        course.setCid(cid);

        this.repo.delete(course);
        
    }

    @Override
    public Set<Courses> getcoursesbyprofe(Professors professors) {
       
        return new LinkedHashSet<>(this.repo.findByProfessors(professors));
    }
    
}
