package com.project.HealthCare.Repository;

import java.util.Set;

import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Lessions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepo extends JpaRepository<Lessions,Long> {

    Set<Lessions> findByCourses(Courses courses);
    
}
