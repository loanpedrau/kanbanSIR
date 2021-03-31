package fr.istic.taa.jaxrs.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/section")
@Produces({"application/json", "application/xml"})
public class SectionResource {

    @GET
    @Path("/all")
    public List<Section> getAllSection()  {
	SectionDao dao = new SectionDao();
	return dao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addSection(
	    @Parameter(description = "Section object that needs to be added to the store", required = true) Section section) {
	// add section
	SectionDao dao = new SectionDao();
	dao.save(section);
	return Response.ok().entity("SUCCESS").build();
    }
}



