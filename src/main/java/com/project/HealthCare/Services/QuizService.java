package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Quiz;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

    public Set<Quiz> getallquizofcourse(Courses courses);
    
    
    
}
