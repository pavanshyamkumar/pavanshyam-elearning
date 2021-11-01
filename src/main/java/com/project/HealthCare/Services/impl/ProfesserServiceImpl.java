package com.project.HealthCare.Services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Repository.ProfessorRepo;
import com.project.HealthCare.Services.ProfeserService;
import com.project.HealthCare.model.Professors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesserServiceImpl implements ProfeserService {

    @Autowired
    private ProfessorRepo repo;

    @Override
    public Professors addProfessors(Professors professors) {
      
        return this.repo.save(professors);
    }

    @Override
    public Professors updaProfessors(Professors professors) {
      
        return this.repo.save(professors);
    }

    @Override
    public Professors getProfessors(Long proid) {
        
        return this.repo.findById(proid).orElse(null);
    }

    @Override
    public Set<Professors> getall() {
      
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public void del(Long proid) {
      
        Professors pro=new Professors();
        pro.setProid(proid);

        this.repo.delete(pro);
    }
    
}
