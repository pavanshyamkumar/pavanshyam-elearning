package com.project.HealthCare.Services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Repository.LessonsRepo;
import com.project.HealthCare.Services.LessionService;
import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Lessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessionServiceImpl implements LessionService {

    @Autowired 
    public LessonsRepo repo;

    @Override
    public Lessions addlessions(Lessions lessions) {
        
        return this.repo.save(lessions);
    }

    @Override
    public Lessions updatelessions(Lessions lessions) {
      
        return this.repo.save(lessions);
    }

    @Override
    public Set<Lessions> getall() {
       
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public Lessions getlession(Long lid) {
       
        return this.repo.findById(lid).orElse(null);
    }

    @Override
    public void del(Long lid) {
     

        Lessions l=new Lessions();
        l.setLid(lid);
        this.repo.delete(l);
        
    }

    @Override
    public Set<Lessions> getlessionofcourse(Courses course) {
       
        return new LinkedHashSet<>(this.repo.findByCourses(course));
    }
    
}
