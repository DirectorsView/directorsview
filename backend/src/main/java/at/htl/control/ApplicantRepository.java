package at.htl.control;

import at.htl.entity.Applicant;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ApplicantRepository implements PanacheRepository<Applicant> {
    public Applicant save(Applicant applicant) {
        return getEntityManager().merge(applicant);
    }
}
