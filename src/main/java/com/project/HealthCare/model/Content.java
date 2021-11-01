package com.project.HealthCare.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long conid;

    private String conname;

    private String downloadlink;

    private String videolink;

    @ManyToOne(fetch = FetchType.EAGER)
    private Lessions lessions;

    public Content() {
    }

    public Long getConid() {
        return conid;
    }

    public void setConid(Long conid) {
        this.conid = conid;
    }

    public String getName() {
        return conname;
    }

    public void setName(String conname) {
        this.conname = conname;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public Lessions getLessons() {
        return lessions;
    }

    public void setLessons(Lessions lessions) {
        this.lessions = lessions;
    }

    public Content(Long conid, String conname, String downloadlink, String videolink, Lessions lessions) {
        this.conid = conid;
        this.conname = conname;
        this.downloadlink = downloadlink;
        this.videolink = videolink;
        this.lessions = lessions;
    }


    


    
}
