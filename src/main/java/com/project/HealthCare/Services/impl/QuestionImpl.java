package com.project.HealthCare.Services.impl;

import java.util.HashSet;
import java.util.Set;

import com.project.HealthCare.Repository.QuestionRepo;
import com.project.HealthCare.Services.QuestionService;
import com.project.HealthCare.model.Question;
import com.project.HealthCare.model.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl implements QuestionService {

    @Autowired
    private QuestionRepo repo;

    @Override
    public Question addQuestion(Question question) {
       
        return this.repo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
       
        return this.repo.save(question);
    }

    @Override
    public Set<Question> getQuestion() {
      
        return new HashSet<>(this.repo.findAll());
    }

    @Override
    public Question gQuestion(Long queid) {
     
        return this.repo.findById(queid).get();
    }

    @Override
    public Set<Question> getQuestionofQuiz(Quiz quiz) {
      
        return this.repo.findByQuiz(quiz);
    }

    @Override
    public void delques(Long quesid) {
       Question q=new Question();
       q.setQuesId(quesid);
       this.repo.delete(q);
        
    }

    @Override
    public Question gett(Long quesId) {
      
    return null;
    }
    
}
