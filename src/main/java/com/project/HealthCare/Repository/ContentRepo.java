package com.project.HealthCare.Repository;


import java.util.Set;

import com.project.HealthCare.model.Content;
import com.project.HealthCare.model.Lessions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepo extends JpaRepository<Content,Long> {

    Set<Content> findByLessions(Lessions lessions);

   
    
}
