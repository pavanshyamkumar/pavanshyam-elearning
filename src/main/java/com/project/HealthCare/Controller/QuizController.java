package com.project.HealthCare.Controller;


import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Services.QuizService;
import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService ser;

    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.ser.addQuiz(quiz));
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.ser.updateQuiz(quiz));
    }

    @GetMapping("/")
    public ResponseEntity<?> quizees()
    {
        return ResponseEntity.ok(this.ser.getQuizes());
    }

    @GetMapping("/{qid}")
    public Quiz quizibyid(@PathVariable("qid") Long qid)
    {
        return this.ser.getQuiz(qid);
    }

    @DeleteMapping("/{qid}")
    public void delQuiz(@PathVariable("qid") Long qid)
    {
        this.ser.deleteQuiz(qid);
    }

    @GetMapping("courses/{cid}")
    public ResponseEntity<?> getquizesofcourses(@PathVariable("cid") Long cid)
    {
        Courses course=new Courses();
        course.setCid(cid);
        Set<Quiz> quizesofcourses=new LinkedHashSet<Quiz>();
        quizesofcourses=this.ser.getallquizofcourse(course);
        return ResponseEntity.ok(quizesofcourses);
    }

    
}
