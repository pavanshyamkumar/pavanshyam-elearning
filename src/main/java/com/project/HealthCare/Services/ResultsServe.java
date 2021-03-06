package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;

public interface ResultsServe {

    public Results addresult(Results results);

    public Results update(Results results);

    public Set<Results> getall();

    public Results getbyid(Long rId);

    public void del(Long rId);

    public Set<Results> geybyquizstudent(Quiz quiz, Students students);
    public Set<Results> geybyquiz(Quiz quiz);
    public Long countattemps(Quiz quiz, Students students);
    
    
}
