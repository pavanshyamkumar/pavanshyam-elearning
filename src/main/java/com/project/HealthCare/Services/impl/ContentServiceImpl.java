package com.project.HealthCare.Services.impl;

import java.util.LinkedHashSet;

import java.util.Set;

import com.project.HealthCare.Repository.ContentRepo;
import com.project.HealthCare.Services.ContentService;
import com.project.HealthCare.model.Content;
import com.project.HealthCare.model.Lessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    public ContentRepo repo;

    @Override
    public Content addcontent(Content content) {
        
        return this.repo.save(content);
    }

    @Override
    public Content updatecontent(Content content) {
        
        return this.repo.save(content);
    }

    @Override
    public Set<Content> getall() {
       
        return new LinkedHashSet<>(this.repo.findAll());
    }

    @Override
    public Content getcontent(Long conid) {

              return this.repo.findById(conid).orElse(null);
    }

    @Override
    public void del(Long conid) {
       Content con=new Content();
       con.setConid(conid);
       this.repo.delete(con);
        
    }

    @Override
    public Set<Content> getcontentoflessions(Lessions lessions) {
       
        return new LinkedHashSet<>(this.repo.findByLessions(lessions));
    }
    
}
