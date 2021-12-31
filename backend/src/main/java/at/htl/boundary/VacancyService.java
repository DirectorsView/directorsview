package at.htl.boundary;

import at.htl.control.ApplicantRepository;
import at.htl.control.VacancyRepository;
import at.htl.entity.Project;
import at.htl.entity.Vacancy;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/vacancy")
@Produces(MediaType.APPLICATION_JSON)
public class VacancyService {

    @Inject
    VacancyRepository vacancyRepository;

    @Inject
    ApplicantRepository applicantRepository;

    @GET
    public List<Vacancy> getAll() {
        return vacancyRepository.listAll();
    }
}
