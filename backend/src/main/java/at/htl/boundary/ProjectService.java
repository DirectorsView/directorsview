package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.control.ProjectMemberRepository;
import at.htl.control.ProjectRepository;
import at.htl.entity.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectService {

    @Inject
    ProjectRepository projectRepository;

    @Inject
    ProjectMemberRepository projectMemberRepository;

    @Inject
    PersonRepository personRepository;

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

    @GET
    @Path("{id}/members")
    public List<Person> getEmployees(@PathParam("id") Long id) {
        return projectMemberRepository.find("project.id", id).stream()
                .map(ProjectMember::getPerson)
                .collect(Collectors.toList());
    }

    @POST
    @Path("{id}/members")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addEmployee(@PathParam("id") Long projectId,
                              @QueryParam("personId") Long personId) {

        Project project = projectRepository.findById(projectId);
        Person person = personRepository.findById(personId);
        projectMemberRepository.save(new ProjectMember(null, project, person));

        return person;
    }
}
