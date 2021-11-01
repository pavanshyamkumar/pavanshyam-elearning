package com.project.HealthCare.Repository;

import com.project.HealthCare.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Long> {
    
}
