package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Courses;
import com.project.HealthCare.model.Professors;

public interface CourseService {

    public Courses  addcourse(Courses course);

    public Courses updatecourses(Courses course);

    public Set<Courses> getall();

    public Courses getcourse(Long cid);

    public void del(Long cid);

    public Set<Courses> getcoursesbyprofe(Professors professors);



    
}
