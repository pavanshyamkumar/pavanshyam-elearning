package com.project.HealthCare.Repository;

import java.util.Set;

import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Professors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses,Long> {

    Set<Courses> findByProfessors(Professors professors);
    
}
