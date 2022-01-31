package at.htl.control;

import at.htl.entity.Company;
import at.htl.entity.Project;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class CompanyRepository implements PanacheRepository<Company> {

    public Company save(Company company) {
        return getEntityManager().merge(company);
    }

    public List<Project> findProjects(Long companyId) {
        return getEntityManager()
                .createNamedQuery("Company.findProjects", Project.class)
                .setParameter("companyId", companyId)
                .getResultList();
    }

}