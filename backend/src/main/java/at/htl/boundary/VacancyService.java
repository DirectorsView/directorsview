package at.htl.boundary;

import at.htl.control.ApplicantRepository;
import at.htl.control.PersonRepository;
import at.htl.control.VacancyRepository;
import at.htl.entity.Applicant;
import at.htl.entity.Person;
import at.htl.entity.Vacancy;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getOne(@PathParam("id") Long id) {

        Vacancy vacancy = vacancyRepository.findById(id);

        if (vacancy == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Vacancy not found")
                    .build();
        } else {
            return Response
                    .ok(vacancy)
                    .build();
        }
    }

    @GET
    @Path("{id}/applicants")
    public List<Person> getApplicants(@PathParam("id") Long id) {
        return applicantRepository.find("vacancy.id", id).stream()
                .map(Applicant::getPerson)
                .collect(Collectors.toList());
    }

    @POST
    @Path("{id}/applicants")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addApplicant(@PathParam("id") Long vacancyId,
                               @QueryParam("personId") Long personId) {

        Vacancy vacancy = vacancyRepository.findById(vacancyId);
        Person person = personRepository.findById(personId);
        applicantRepository.save(new Applicant(null, vacancy, person));

        return person;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Vacancy put(@PathParam("id") long id, Vacancy vacancy) {
        Vacancy originalVacancy = vacancyRepository.findById(id);

        if (originalVacancy != null) {
            originalVacancy.setTitle(vacancy.getTitle());
            originalVacancy.setDeadline(vacancy.getDeadline());
            originalVacancy.setOpened(vacancy.getOpened());
            originalVacancy.setCompany(vacancy.getCompany());
            originalVacancy.setProject(vacancy.getProject());
        }

        return originalVacancy;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Vacancy delete(@PathParam("id") long id) {
        Vacancy vacancy = vacancyRepository.findById(id);
        vacancy.delete("id = " + id);
        return vacancy;
    }

}