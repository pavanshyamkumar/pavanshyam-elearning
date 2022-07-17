package com.project.HealthCare.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rId;

    private int attempted;

    private double marksgot;

    private double persentage;

    private int correctanswers;

    @ManyToOne(fetch = FetchType.EAGER)
    private Students students;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    public Results() {
    }

  

    public int getCorrectanswers() {
        return correctanswers;
    }



    public void setCorrectanswers(int correctanswers) {
        this.correctanswers = correctanswers;
    }



    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public int getAttempted() {
        return attempted;
    }

    public void setAttempted(int attempted) {
        this.attempted = attempted;
    }

    public double getMarksgot() {
        return marksgot;
    }

    public void setMarksgot(double marksgot) {
        this.marksgot = marksgot;
    }

    public double getPersentage() {
        return persentage;
    }

    public void setPersentage(double persentage) {
        this.persentage = persentage;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    


    
}
