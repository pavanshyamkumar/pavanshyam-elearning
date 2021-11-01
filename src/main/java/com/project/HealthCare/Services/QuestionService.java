package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Question;
import com.project.HealthCare.model.Quiz;


public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestion();

    public Question gQuestion(Long queid);

    public void delques(Long quesid);

    public Set<Question> getQuestionofQuiz(Quiz quiz);
    
    public Question gett(Long quesId);
    
    
}
