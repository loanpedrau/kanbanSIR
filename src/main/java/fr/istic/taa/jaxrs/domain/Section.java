package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Section implements Serializable {

    long id;
    String name;
    List<Fiche> fiches;
    KanbanBoard kanbanBoard;
    
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany(mappedBy = "section")
    public List<Fiche> getFiches() {
        return fiches;
    }
    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
    
    @ManyToOne
    public KanbanBoard getKanbanBoard() {
        return kanbanBoard;
    }
    public void setKanbanBoard(KanbanBoard kanbanBoard) {
        this.kanbanBoard = kanbanBoard;
    }
    
    
}
