package com.project.HealthCare.Controller;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Services.LessionService;
import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Lessions;

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
@RequestMapping("lessions")
@CrossOrigin("*")
public class LessionsController {

    @Autowired
    public LessionService ser;

    @PostMapping("/save")
    public Lessions add(@RequestBody Lessions lessions)
    {
        return this.ser.addlessions(lessions);
    }

    @PutMapping("/")
    public Lessions upda(@RequestBody Lessions lessions)
    {
        return this.ser.updatelessions(lessions);
    }

    @GetMapping("/")
    public ResponseEntity<?> getall()
    {
        return ResponseEntity.ok(this.ser.getall());
    }
    
    @GetMapping("/{lid}")
    public Lessions get(@PathVariable("lid") Long lid)
    {
        return this.ser.getlession(lid);
    }
    @DeleteMapping("/{lid}")
    public void del(@PathVariable("lid") Long lid)
    {
        this.ser.del(lid);
    }

    @GetMapping("/courses/{cid}")
    public ResponseEntity<?> getLessionsOfCourse(@PathVariable("cid") Long cid)
    {
        Courses course=new Courses();
        course.setCid(cid);
        Set<Lessions> lessionsofcourse=new LinkedHashSet<Lessions>() ;
        lessionsofcourse=this.ser.getlessionofcourse(course);
        return ResponseEntity.ok(lessionsofcourse);
    }
}
