package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Professors;

public interface ProfeserService {


    public Professors addProfessors(Professors professors);

    public Professors updaProfessors(Professors professors);

    public Professors getProfessors(Long proid);

    public Set<Professors> getall();

    public void del(Long proid);
    
}
