package fr.istic.taa.jaxrs.rest;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Admin;
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
    
    @DELETE
    public Response deleteUser(@QueryParam("email") String email)  {
	UtilisateurDao dao = new UtilisateurDao();
	dao.delete(dao.findByEmail(email));
	return Response.ok().entity("SUCCESS").build();
    }
    
    @PUT
    @Consumes("application/json")
    public Response modifyUser(
	    @Parameter(description = "User object that needs to be modify (email cannot be modify)", required = true) Utilisateur user)  {
	UtilisateurDao dao = new UtilisateurDao();
	dao.update(user);
	return Response.ok().entity("SUCCESS").build();
    }
    
    @GET
    @Path("/name")
    public List<Utilisateur> getAllUsersByName(@QueryParam("name") String name)  {
	UtilisateurDao dao = new UtilisateurDao();
	return dao.getAllUsersByName(name);
    }
    
    @GET
    @Path("/email")
    public List<Utilisateur> getAllUsersByEmail(@QueryParam("email") String email)  {
	UtilisateurDao dao = new UtilisateurDao();
	return dao.getAllUsersByEmail(email);
    }
    
    @GET
    @Path("/admin")
    public List<Utilisateur> getAllAdmin()  {
	UtilisateurDao dao = new UtilisateurDao();
	return dao.getAllAdmin();
    }

    @POST
    @Consumes("application/json")
    public Response addUtilisateur(
	    @Parameter(description = "User object that needs to be added to the store", required = true) Utilisateur user) {
	UtilisateurDao dao = new UtilisateurDao();
	dao.save(user);
	return Response.ok().entity("SUCCESS").build();
    }
    
    @POST
    @Path("/admin")
    @Consumes("application/json")
    public Response addAdmin(
	    @Parameter(description = "Admin object that needs to be added to the store", required = true) Admin admin) {
	UtilisateurDao dao = new UtilisateurDao();
	dao.save(admin);
	return Response.ok().entity("SUCCESS").build();
    }
}

