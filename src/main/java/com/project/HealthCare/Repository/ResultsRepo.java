package com.project.HealthCare.Repository;

import java.util.Set;

import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ResultsRepo extends JpaRepository<Results,Long> {

    public Set<Results> findByQuizAndStudents(Quiz quiz, Students students);

    public Long countByQuizAndStudents(Quiz quiz,Students students);

   
    public Set<Results> findByQuiz(Quiz quiz);
}
