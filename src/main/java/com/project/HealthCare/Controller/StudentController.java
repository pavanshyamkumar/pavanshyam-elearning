package com.project.HealthCare.Controller;

import com.project.HealthCare.Services.StudentService;
import com.project.HealthCare.model.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{stuid}")
    public Students gStudents(@PathVariable("stuid") Long stuid)
    {
        return this.studentService.getby(stuid);
    }

    @PutMapping("/")
    public Students updaStudents(@RequestBody Students students)
    {
        return this.studentService.updaStudents(students);
    }

    @GetMapping("/")
    public ResponseEntity<?> geta()
    {
        return ResponseEntity.ok(this.studentService.getall());
    }

    @DeleteMapping("/{stuid}")
    public void del(@PathVariable("stuid") Long stuid)
    {
        this.studentService.del(stuid);
    }

    
}
