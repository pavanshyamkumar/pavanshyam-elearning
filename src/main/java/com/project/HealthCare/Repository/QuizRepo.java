package com.project.HealthCare.Repository;

import java.util.Set;

import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {

    public Set<Quiz> findByCourses(Courses courses);
    
}
