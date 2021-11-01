package com.project.HealthCare.Services.impl;


import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Repository.QuizRepo;
import com.project.HealthCare.Services.QuizService;
import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizImpl implements QuizService {

    @Autowired
    private QuizRepo repo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
     
        return this.repo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
       
        return this.repo.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
       
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
    
        return this.repo.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz=new Quiz();
        quiz.setqId(quizId);
        this.repo.delete(quiz);
        
    }

    @Override
    public Set<Quiz> getallquizofcourse(Courses courses) {
      
        return  new LinkedHashSet<>(this.repo.findByCourses(courses));
    }
    
}
