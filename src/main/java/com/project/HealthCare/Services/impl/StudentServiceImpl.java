package com.project.HealthCare.Services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Repository.StudentRepo;
import com.project.HealthCare.Services.StudentService;
import com.project.HealthCare.model.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    @Override
    public Students addStudents(Students students) {
       
        return this.repo.save(students);
    }

    @Override
    public Students updaStudents(Students students) {
       
        return this.repo.save(students);
    }

    @Override
    public Students getby(Long stuid) {
       
        return this.repo.findById(stuid).orElse(null);
    }

    @Override
    public Set<Students> getall() {
      
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public void del(Long stuid) {
      
        Students stu=new Students();
        stu.setStuid(stuid);
        this.repo.delete(stu);
        
    }
    
}
