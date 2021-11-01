package com.project.HealthCare.Controller;

import com.project.HealthCare.Services.ProfeserService;
import com.project.HealthCare.model.Professors;

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
@RequestMapping("/professor")
@CrossOrigin("*")
public class ProfessorController {

    @Autowired
    private ProfeserService profeserService;

    @GetMapping("/{proid}")
    public Professors getpProfessors(@PathVariable("proid") Long proid)
    {
        return this.profeserService.getProfessors(proid);
    }

    @PutMapping("/")
    public Professors updProfessors(@RequestBody Professors professors)
    {
        return this.profeserService.updaProfessors(professors);
    }

    @GetMapping("/")
    public ResponseEntity<?> getal()
    {
        return ResponseEntity.ok(this.profeserService.getall());
    }

    @DeleteMapping("/{proid}")
    public void del(@PathVariable("proid") Long proid)
    {
        this.profeserService.del(proid);
    }
    
}
