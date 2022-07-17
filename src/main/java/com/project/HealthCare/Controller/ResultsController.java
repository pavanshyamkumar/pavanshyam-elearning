package com.project.HealthCare.Controller;

import com.project.HealthCare.Services.ResultsServe;
import com.project.HealthCare.Services.StudentService;
import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;
import java.util.*;
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
@RequestMapping("/results")
@CrossOrigin("*")
public class ResultsController {

    @Autowired
    public ResultsServe ser;

    @Autowired
    public StudentService stuser;

    @PostMapping("/")
    public Results add(@RequestBody Results results) {
        return this.ser.addresult(results);
    }

    @GetMapping("/{rId}")
    public Results getbyid(@PathVariable("rId") Long rId) {
        return this.ser.getbyid(rId);
    }

    @PutMapping("/")
    public Results update(@RequestBody Results results) {
        return this.ser.update(results);
    }

    @GetMapping("/")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(this.ser.getall());
    }

    @DeleteMapping("/{rId}")
    public void del(@PathVariable("rId") Long rId) {
        this.ser.del(rId);
    }

    @GetMapping("/{qId}/{studentId}")
    public ResponseEntity<?> getbyquizstd(@PathVariable("qId") Long qId, @PathVariable("studentId") Long studentId) {
        Quiz q = new Quiz();
        q.setqId(qId);

        Students st = new Students();
        st.setStuid(studentId);

        return ResponseEntity.ok(this.ser.geybyquizstudent(q, st));
    }

    // count the attempts

    @GetMapping("/attempts/{qId}/{studentId}")
    public ResponseEntity<?> countattempts(@PathVariable("qId") Long qId, @PathVariable("studentId") Long studentId) {
        Quiz q = new Quiz();
        q.setqId(qId);

        Students st = new Students();
        st.setStuid(studentId);

        Long k = this.ser.countattemps(q, st);
        Map<String, Object> map = Map.of("k", k);
        return ResponseEntity.ok(map);
    }

    // leaderboard
    @GetMapping("/leader/{qId}")
    public ResponseEntity<?> leader(@PathVariable("qId") Long qId) {

        Set<Students> stu = new LinkedHashSet<>(this.stuser.getall());

        // Set<Results> s=new LinkedHashSet<>(this.ser.geybyquiz(q));

        Set<Results> leader = new LinkedHashSet<>();

        for (Students st : stu) {
            Quiz q = new Quiz();
            q.setqId(qId);
            Students stuu = new Students();
            stuu.setStuid(st.getStuid());
            Set<Results> geteachstudentresult = new LinkedHashSet<>(this.ser.geybyquizstudent(q, stuu));

            Set<Double> getper = new LinkedHashSet<>();
            for (Results results : geteachstudentresult) {

                getper.add(results.getPersentage());

            }

            double maximum = Collections.max(getper);

            System.out.println("list:" + maximum);

            for (Results results : geteachstudentresult) {

                if (results.getPersentage() == maximum) {
                    leader.add(results);
                    break;
                }

            }

        }

        return ResponseEntity.ok(leader);
    }
}
