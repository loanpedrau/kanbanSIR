package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name = "KanbanBoard")
public class KanbanBoard implements Serializable{

    long id;
    String name;
    List<Section> sections;
    List<Utilisateur> users;
    
    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    long getId() {
	return id;
    }
    
    void setId(long id) {
	this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy="kanbanBoard")
    @XmlTransient
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @ManyToMany(mappedBy="kanbanBoards")
    @XmlTransient
    public List<Utilisateur> getUsers() {
        return users;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }
    
}
