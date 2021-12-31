package at.htl.boundary;

import at.htl.control.ApplicantRepository;
import at.htl.control.PersonRepository;
import at.htl.control.VacancyRepository;
import at.htl.entity.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/vacancy")
@Produces(MediaType.APPLICATION_JSON)
public class VacancyService {

    @Inject
    VacancyRepository vacancyRepository;

    @Inject
    ApplicantRepository applicantRepository;

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Vacancy> getAll() {
        return vacancyRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Vacancy post(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @GET
    @Path("{id}")
    public Vacancy getOne(@PathParam("id") Long id) {
        return vacancyRepository.findById(id);
    }

    @GET
    @Path("{id}/applicants")
    public List<Person> getApplicants(@PathParam("id") Long id) {
        return applicantRepository.find("vacancy.id", id).stream()
                .map(Applicant::getPerson)
                .collect(Collectors.toList());
    }
}
