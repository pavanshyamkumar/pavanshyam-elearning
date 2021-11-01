package com.project.HealthCare.Repository;

import java.util.Set;

import com.project.HealthCare.model.Question;
import com.project.HealthCare.model.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long> {

    Set<Question> findByQuiz(Quiz quiz);
    
}
