package com.project.HealthCare.Services;


import java.util.Set;

import com.project.HealthCare.model.Content;
import com.project.HealthCare.model.Lessions;

public interface ContentService {


    public Content addcontent(Content content);

    public Content updatecontent(Content content);

    public Set<Content> getall();
    

    public Content getcontent(Long conid);

    public void del(Long conid);

    public Set<Content> getcontentoflessions(Lessions lessions);
    
}
