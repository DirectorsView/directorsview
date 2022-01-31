package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entity.Person;
import at.htl.entity.Project;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public Person post(Person person) {
        return repository.save(person);
    }

    @GET
    @Path("{id}")
    public Person getOne(@PathParam("id") Long id) {
        return repository.findById(id);
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