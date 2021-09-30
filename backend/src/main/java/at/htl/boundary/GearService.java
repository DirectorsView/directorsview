package at.htl.boundary;

import at.htl.control.GearRepository;
import at.htl.entity.Company;
import at.htl.entity.Gear;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/gear")
@Produces(MediaType.APPLICATION_JSON)
public class GearService {
    @Inject
    GearRepository repository;

    @GET
    public List<Gear> getAll() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Gear post(Gear gear) {

        return repository.save(gear);
    }
}
