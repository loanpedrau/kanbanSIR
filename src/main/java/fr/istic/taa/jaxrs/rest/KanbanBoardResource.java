package fr.istic.taa.jaxrs.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.dao.generic.KanbanDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.KanbanBoard;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/kanban")
@Produces({"application/json", "application/xml"})
public class KanbanBoardResource {

    @GET
    @Path("/all")
    public List<KanbanBoard> getAllKanban()  {
	KanbanDao dao = new KanbanDao();
	return dao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addKanban(
	    @Parameter(description = "Kanban object that needs to be added to the store", required = true) KanbanBoard kanban) {
	KanbanDao dao = new KanbanDao();
	dao.save(kanban);
	return Response.ok().entity("SUCCESS").build();
    }
}


