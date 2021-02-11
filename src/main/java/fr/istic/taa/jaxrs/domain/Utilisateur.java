package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType=DiscriminatorType.STRING)
@NamedQueries(
	{@NamedQuery(name="touslesutilisateurs", query="select u from Utilisateur u"),
	@NamedQuery(name="touslesutilisateursParNom", query="select u from Utilisateur u where u.name=:name")})
@XmlRootElement(name = "Utilisateur")
public class Utilisateur implements Serializable{

    String email;
    String name;
    List<Fiche> fiches;
    List<KanbanBoard> kanbanBoards;
    
    @Id
    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany(mappedBy = "utilisateur")
    @XmlElementWrapper(name = "fiches")
    @XmlElement(name = "fiches")
    public List<Fiche> getFiches() {
        return fiches;
    }
    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
    
    @ManyToMany
    @XmlElementWrapper(name = "kanbanBoards")
    @XmlElement(name = "kanbanBoards")
    public List<KanbanBoard> getKanbanBoards() {
        return kanbanBoards;
    }
    public void setKanbanBoards(List<KanbanBoard> kanbanBoards) {
        this.kanbanBoards = kanbanBoards;
    }
    
    
}
