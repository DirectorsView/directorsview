package at.htl.boundary;

import at.htl.control.ProjectRepository;
import at.htl.entity.Company;
import at.htl.entity.Person;
import at.htl.entity.Project;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectService {

    @Inject
    ProjectRepository projectRepository;

    @GET
    public List<Project> getAll() {
        return projectRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Project post(Project project) {
        return projectRepository.save(project);
    }

    @GET
    @Path("{id}")
    public Project getOne(@PathParam("id") Long id) {
        return projectRepository.findById(id);
    }
}
