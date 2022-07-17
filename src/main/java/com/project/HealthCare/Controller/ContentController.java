package com.project.HealthCare.Controller;

import java.util.LinkedHashSet;
import java.util.Set;

import com.project.HealthCare.Services.ContentService;
import com.project.HealthCare.model.Content;
import com.project.HealthCare.model.Lessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
@CrossOrigin("*")
public class ContentController {

    @Autowired
    public ContentService ser;

   @PostMapping("/save")
   public Content add(@RequestBody Content content)
   {
       return this.ser.addcontent(content);
   }
    

   @PutMapping("/update")
   public ResponseEntity<Content> upda(@RequestBody Content content)
   {
       return ResponseEntity.ok(ser.updatecontent(content));
   }

   @GetMapping("/all")
   public ResponseEntity<?> getall()
   {
       return ResponseEntity.ok(this.ser.getall());
   }

   @GetMapping("/{conid}")
   public Content get(@PathVariable("conid") Long conid)
   {
       return this.ser.getcontent(conid);
   }

   @DeleteMapping("/{conid}")
   public void del(@PathVariable("conid") Long conid)
   {
       this.ser.del(conid);
   }

   @GetMapping("/lessions/{lid}")
   public ResponseEntity<?> getcontentBYlessions(@PathVariable("lid") Long lid)
   {
       Lessions lessions=new Lessions();
       lessions.setLid(lid);
       Set<Content> contetoflessions=new LinkedHashSet<Content>();
       contetoflessions=this.ser.getcontentoflessions(lessions);
       return ResponseEntity.ok(contetoflessions);
       
   }
}
