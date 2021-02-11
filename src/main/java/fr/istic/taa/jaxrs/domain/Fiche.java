package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name = "Fiche")
public class Fiche implements Serializable {

    long id;
    int position;
    String libelle;
    Date date_butoire;
    int requiredTime;
    String tags;
    String lieu;
    String url;
    String note;
    Utilisateur utilisateur;
    Section section;
    
    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @XmlElement(name = "position")
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    
    @XmlElement(name = "libelle")
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    @XmlElement(name = "date_butoire")
    public Date getDate_butoire() {
        return date_butoire;
    }
    public void setDate_butoire(Date date_butoire) {
        this.date_butoire = date_butoire;
    }
    
    @XmlElement(name = "requiredTime")
    public int getRequiredTime() {
        return requiredTime;
    }
    public void setRequiredTime(int requiredTime) {
        this.requiredTime = requiredTime;
    }
    
    @XmlElement(name = "tags")
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    
    @XmlElement(name = "lieu")
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    @XmlElement(name = "note")
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
    @ManyToOne
    @XmlTransient
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    @ManyToOne
    @XmlTransient
    public Section getSection() {
        return section;
    }
    public void setSection(Section section) {
        this.section = section;
    }
    
}
