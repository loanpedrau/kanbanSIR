package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name = "Section")
public class Section implements Serializable {

    long id;
    String name;
    List<Fiche> fiches;
    KanbanBoard kanbanBoard;
    
    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany(mappedBy = "section")
    @XmlTransient
    public List<Fiche> getFiches() {
        return fiches;
    }
    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
    
    @ManyToOne
    @XmlTransient
    public KanbanBoard getKanbanBoard() {
        return kanbanBoard;
    }
    public void setKanbanBoard(KanbanBoard kanbanBoard) {
        this.kanbanBoard = kanbanBoard;
    }
    
    
}
