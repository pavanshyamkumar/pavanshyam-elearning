package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Students;

public interface StudentService {

    public Students addStudents(Students students);
    
    public Students updaStudents(Students students);

    public Students getby(Long stuid);

    public Set<Students> getall();

    public void del(Long stuid);
    
    
}
