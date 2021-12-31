package at.htl.boundary;

import at.htl.control.ApplicantRepository;
import at.htl.control.VacancyRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vacancy")
@Produces(MediaType.APPLICATION_JSON)
public class VacancyService {

    @Inject
    VacancyRepository vacancyRepository;

    @Inject
    ApplicantRepository applicantRepository;
}
