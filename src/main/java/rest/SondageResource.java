package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import domain.Sondage;
import dao.SondageDAO;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/survey")
@Produces({"application/json", "application/xml"})
public class SondageResource {

    @GET
    @Path("/")
    public List<Sondage> getAllSondage() {
        return SondageDAO.getSondages();
    }

    @GET
    @Path("/byId/{surveyId}")
    public Sondage getSondageById(@PathParam("surveyId") Long id) {
        return SondageDAO.getSondageById(id);
    }

    @GET
    @Path("/byTitle/{surveyTitle}")
    public List<Sondage> getSondageByTitre(@PathParam("surveyTitle") String titre){
        return SondageDAO.getSondageByTitre(titre);
    }

    @POST
    @Consumes("application/json")
    public Response createSurvey(
            @Parameter(description = "Create a new survey", required = true) Sondage sondage) {
        SondageDAO.rentrerNouvelleDonnees(sondage.getTitre(), sondage.getLieu());
        return Response.ok().entity("SUCCESS").build();
    }
}
