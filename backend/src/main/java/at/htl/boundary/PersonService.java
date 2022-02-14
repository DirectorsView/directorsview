package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entity.Person;
import at.htl.entity.Project;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonService {
    @Inject
    PersonRepository repository;

    @GET
    public List<Person> getAll() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Person person) {
        try {
            return Response
                    .ok(repository.save(person))
                    .build();
        } catch (PersistenceException e) {
            return Response
                    .status(400)
                    .entity("Email already used")
                    .build();
        }
    }

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Long id) {
        Person person = repository.findById(id);

        if (person == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Person not found")
                    .build();
        } else {
            return Response
                    .ok(person)
                    .build();
        }
    }

    @GET
    @Path("/{id}/projects")
    public List<Project> getProjects(@PathParam("id") Long id) {
        return repository.findProjects(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Person put(@PathParam("id") long id, Person person) {
        Person originalPerson = repository.findById(id);

        if (originalPerson != null) {
            originalPerson.setPassword(person.getPassword());
            originalPerson.setEmail(person.getEmail());
            originalPerson.setWebsite(person.getWebsite());
            originalPerson.setFirstName(person.getFirstName());
            originalPerson.setLastName(person.getLastName());
            originalPerson.setBirthdate(person.getBirthdate());
        }

        return originalPerson;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Person delete(@PathParam("id") long id) {
        Person person = repository.findById(id);
        repository.delete("id = " + id);
        return person;
    }

}