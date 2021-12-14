package at.htl.boundary;

import at.htl.control.ProjectRepository;
import at.htl.entity.Company;
import at.htl.entity.Project;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
