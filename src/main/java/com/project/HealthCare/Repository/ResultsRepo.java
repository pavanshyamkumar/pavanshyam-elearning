package com.project.HealthCare.Repository;



import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultsRepo extends JpaRepository<Results,Long> {

    public Results findByQuizAndStudents(Quiz quiz, Students students);
    
}
