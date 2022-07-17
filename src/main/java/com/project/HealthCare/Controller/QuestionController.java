package com.project.HealthCare.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import com.project.HealthCare.Services.QuestionService;
import com.project.HealthCare.Services.QuizService;
import com.project.HealthCare.Services.ResultsServe;
import com.project.HealthCare.model.Question;
import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;

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
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService ser;

    @Autowired 
    private QuizService qser;

    @Autowired
    private ResultsServe rser;


    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.ser.addQuestion(question)); 
    }

    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.ser.updateQuestion(question)); 
    }

    @GetMapping("/")
    public ResponseEntity<?> questions()
    {
        return ResponseEntity.ok(this.ser.getQuestion());
    }

    @GetMapping("/{queid}")
    public Question getbyid(@PathVariable("queid") Long queid)
    {
        return this.ser.gQuestion(queid);
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsofquizz(@PathVariable("qid") Long qid)
    {
        Quiz quiz=this.qser.getQuiz(qid);
      Set<Question> questions=  quiz.getQuestions();

      List<Question> list=new ArrayList<Question>(questions);
      if(list.size()>Integer.parseInt(quiz.getNumberofQuestions()))
      {
            list=list.subList(0,Integer.parseInt(quiz.getNumberofQuestions()));
      }
        Collections.shuffle(list);
      return ResponseEntity.ok(list);
    }

     @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsofquizzAdmin(@PathVariable("qid") Long qid)
    {
       Quiz quiz=new Quiz();
       quiz.setqId(qid);
       Set<Question> q=this.ser.getQuestionofQuiz(quiz);
      return ResponseEntity.ok(q);
    }

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId)
    {
        this.ser.delques(quesId);
    }


    //evaluate quiz

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {
        System.out.println(questions);
        int correct=0;
        int attempted=0;
        double marksgot=0;
        double persentage=0;
        int notattempted=0;
        
       for(Question q:questions){
           Question qq=this.ser.gQuestion(q.getQuesId());
           if(qq.getAnswer().equals(q.getGivenAnswer()))
           {
               //
               correct=correct+1;

               double markssingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksgot+=markssingle;
               

           }

           if(q.getGivenAnswer()!=null)
           {
                attempted++;
           }
           
        }
        System.out.println(correct);
        System.out.println("attempted:-"+notattempted);
        System.out.println(marksgot);
        persentage=(marksgot/Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()))*100;
        System.out.println(persentage);

        //add results

        Results results=new Results();
         results.setAttempted(attempted);
         results.setMarksgot(marksgot);
         results.setQuiz(questions.get(0).getQuiz());
         results.setPersentage(persentage);
         results.setCorrectanswers(correct);

         Students st=new Students();
         st.setStuid(questions.get(0).getStudentId());

         results.setStudents(st);

         this.rser.addresult(results);
        Map<String,Object> map=Map.of("marksgot",marksgot,"correct",correct,"attempted",attempted,"persentage",persentage," notattempted", notattempted);


      

        return ResponseEntity.ok(map);
    }





    
}
