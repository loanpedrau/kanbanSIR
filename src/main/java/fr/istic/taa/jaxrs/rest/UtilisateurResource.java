package fr.istic.taa.jaxrs.rest;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/users")
@Produces({"application/json", "application/xml"})
public class UtilisateurResource {

    @GET
    @Path("/all")
    public List<Utilisateur> getAllUsers()  {
	UtilisateurDao dao = new UtilisateurDao();
	return dao.findAll();
    }
    
    @GET
    @Path("/admins")
    public List<Utilisateur> getAllAdmin()  {
	UtilisateurDao dao = new UtilisateurDao();
	return dao.getAllAdmin();
    }

    @POST
    @Consumes("application/json")
    public Response addUtilisateur(
	    @Parameter(description = "Utilisateur object that needs to be added to the store", required = true) Utilisateur user) {
	// add fiche
	UtilisateurDao dao = new UtilisateurDao();
	dao.save(user);
	return Response.ok().entity("SUCCESS").build();
    }
}

