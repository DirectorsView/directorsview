package at.htl.control;

import at.htl.entity.Company;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.security.PublicKey;

@ApplicationScoped
@Transactional
public class CompanyRepository implements PanacheRepository<Company> {

    @Inject
    EntityManager em;

    public Company save(Company company) {
        return em.merge(company);
    }
}
