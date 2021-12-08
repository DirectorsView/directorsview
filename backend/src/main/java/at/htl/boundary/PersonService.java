package at.htl.boundary;

import at.htl.control.PersonRepository;
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
    public List<Person> getAll() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Person post(Person person) {
        return repository.save(person);
    }
}
