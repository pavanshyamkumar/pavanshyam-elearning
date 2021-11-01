package com.project.HealthCare.Repository;

import com.project.HealthCare.model.Professors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professors,Long> {
    
}
