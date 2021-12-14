package at.htl.boundary;

import at.htl.control.CompanyRepository;
import at.htl.entity.Company;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {
    @Inject
    CompanyRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAll() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Company post(Company company) {
        return repository.save(company);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getOne(@PathParam("id") Long id) {
        return repository.findById(id);
    }

}
