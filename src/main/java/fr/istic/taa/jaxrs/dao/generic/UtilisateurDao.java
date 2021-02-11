package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Admin;
import fr.istic.taa.jaxrs.domain.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur> {

    public UtilisateurDao() {
	super(Utilisateur.class);
    }
    
    public List<Utilisateur> getAllUsers(){
	List<Utilisateur> utilisateurs = entityManager.createNamedQuery("touslesutilisateurs", Utilisateur.class)
		.getResultList();
	return utilisateurs;
    }
    
    public List<Utilisateur> getAllAdmin(){
	List<Utilisateur> admins = entityManager.createQuery("select u from Utilisateur u where u.role:'Admin'")
		.getResultList();
	return admins;
    }
}