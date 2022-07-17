package com.project.HealthCare.Services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Repository.ResultsRepo;
import com.project.HealthCare.Services.ResultsServe;
import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsServiceImpl implements ResultsServe {

    @Autowired
    public ResultsRepo repo;

    @Override
    public Results addresult(Results results) {
      
        return this.repo.save(results);
    }

    @Override
    public Results update(Results results) {
     
        return this.repo.save(results);
    }

    @Override
    public Set<Results> getall() {
      
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public Results getbyid(Long rId) {
       
        return this.repo.findById(rId).orElse(null);
    }

    @Override
    public void del(Long rId) {
      
        Results re=new Results();
        re.setrId(rId);
        this.repo.delete(re);
        
    }

    @Override
    public Set<Results> geybyquizstudent(Quiz quiz, Students students) {
        
        return new LinkedHashSet<>(this.repo.findByQuizAndStudents(quiz, students));
    }

    @Override
    public Long countattemps(Quiz quiz, Students students)
    {
        return this.repo.countByQuizAndStudents(quiz,students);
    }

    @Override
    public Set<Results> geybyquiz(Quiz quiz) {
    
        return new LinkedHashSet<>(this.repo.findByQuiz(quiz));
    }

    
    
}
