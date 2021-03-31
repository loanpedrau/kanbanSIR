package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Admin;
import fr.istic.taa.jaxrs.domain.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur> {

    public UtilisateurDao() {
	super(Utilisateur.class);
    }
    
    public Utilisateur findByEmail(String email) {
	return (Utilisateur) entityManager.createQuery("select u from Utilisateur u where u.email=:email").setParameter("email", email).getSingleResult();
    }
    
    public List<Utilisateur> getAllUsers(){
	return entityManager.createNamedQuery("allUsers", Utilisateur.class).getResultList();
    }
    
    public List<Utilisateur> getAllUsersByName(String name){
	List<Utilisateur> utilisateurs = entityManager.createNamedQuery("allUsersByName", Utilisateur.class)
		.setParameter("name", name)
		.getResultList();
	return utilisateurs;
    }
    
    public List<Utilisateur> getAllUsersByEmail(String email){
	return entityManager.createNamedQuery("allUsersByEmail", Utilisateur.class)
		.setParameter("email", email)
		.getResultList();
    }
    
    public List<Utilisateur> getAllAdmin(){
	return entityManager.createQuery("select a from Admin a").getResultList();
    }
}