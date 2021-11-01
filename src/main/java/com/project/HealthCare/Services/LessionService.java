package com.project.HealthCare.Services;


import java.util.Set;

import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Lessions;

public interface LessionService {

    public Lessions addlessions(Lessions lessions);

    public Lessions updatelessions(Lessions lessions);

    public Set<Lessions> getall();

    public Lessions getlession(Long lid);

    public void del(Long lid);

    public Set<Lessions> getlessionofcourse(Courses course);
    
}
