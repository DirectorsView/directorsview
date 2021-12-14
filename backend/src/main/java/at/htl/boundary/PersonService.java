package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entity.Company;
import at.htl.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonService {
    @Inject
    PersonRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person post(Person person) {
        return repository.save(person);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getOne(@PathParam("id") Long id) {
        return repository.findById(id);
    }
}
