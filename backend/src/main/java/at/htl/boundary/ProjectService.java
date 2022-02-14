package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.control.ProjectMemberRepository;
import at.htl.control.ProjectRepository;
import at.htl.entity.Person;
import at.htl.entity.Project;
import at.htl.entity.ProjectMember;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getOne(@PathParam("id") Long id) {
        Project project = projectRepository.findById(id);

        if (project == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Project not found")
                    .build();
        } else {
            return Response
                    .ok(project)
                    .build();
        }
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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Project put(@PathParam("id") long id, Project project) {
        Project originalProject = projectRepository.findById(id);

        if (originalProject != null) {
            originalProject.setName(project.getName());
            originalProject.setDescription(project.getDescription());
            originalProject.setStartTime(project.getStartTime());
            originalProject.setEndTime(project.getEndTime());
            originalProject.setCompany(project.getCompany());
        }

        return originalProject;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Project delete(@PathParam("id") long id) {
        Project project = projectRepository.findById(id);
        projectMemberRepository.delete("project = " + id);
        project.delete("id = " + id);
        return project;
    }

}