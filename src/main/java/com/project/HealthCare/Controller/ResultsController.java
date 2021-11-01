package com.project.HealthCare.Controller;

import com.project.HealthCare.Services.ResultsServe;
import com.project.HealthCare.model.Quiz;
import com.project.HealthCare.model.Results;
import com.project.HealthCare.model.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class ResultsController {

    @Autowired
    public ResultsServe ser;

    @PostMapping("/")
    public Results add(@RequestBody Results results)
    {
        return this.ser.addresult(results);
    }

    @GetMapping("/{rId}")
    public Results getbyid(@PathVariable("rId") Long rId)
    {
        return this.ser.getbyid(rId);
    }

    @PutMapping("/")
    public Results update(@RequestBody Results results)
    {
        return this.ser.update(results);
    }

    @GetMapping("/")
    public ResponseEntity<?> getall()
    {
        return ResponseEntity.ok(this.ser.getall());
    }

    @DeleteMapping("/{rId}")
    public void del(@PathVariable("rId") Long rId)
    {
        this.ser.del(rId);
    }

    @GetMapping("/{qId}/{studentId}")
    public Results getbyquizstd(@PathVariable("qId") Long qId,@PathVariable("studentId") Long studentId)
    {
        Quiz q=new Quiz();
        q.setqId(qId);

        Students st=new Students();
        st.setStuid(studentId);


        return this.ser.geybyquizstudent(q, st);
    }
    
}
