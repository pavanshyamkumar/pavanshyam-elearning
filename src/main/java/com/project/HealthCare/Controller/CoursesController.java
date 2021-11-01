package com.project.HealthCare.Controller;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Services.CourseService;
import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Professors;

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
@RequestMapping("/courses")
@CrossOrigin("*")
public class CoursesController {

    @Autowired
    public CourseService ser;

    @PostMapping("/save")
    public Courses addcourse(@RequestBody Courses course)
    {
        return this.ser.addcourse(course);
    }

    @GetMapping("/{cid}")
    public Courses getcourses(@PathVariable("cid") Long cid)
    {
        return this.ser.getcourse(cid);
    }

    @PutMapping("/update")
    public Courses upd(@RequestBody Courses course)
    {
        return this.ser.updatecourses(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getall()
    {
        return ResponseEntity.ok(this.ser.getall());
    }
    
    @DeleteMapping("/{cid}")
    public void del(@PathVariable("cid") Long cid)
    {
        this.ser.del(cid);
    }

    @GetMapping("/professor/{proid}")
    public ResponseEntity<?> getbyprofeser(@PathVariable("proid") Long proid)
    {
        Professors pro=new Professors();
        pro.setProid(proid);
        Set<Courses> courseofprofessors=new LinkedHashSet<Courses>() ;
        courseofprofessors=this.ser.getcoursesbyprofe(pro);
        return ResponseEntity.ok(courseofprofessors);



    }
}
