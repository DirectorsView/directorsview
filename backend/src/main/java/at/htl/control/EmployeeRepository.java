package at.htl.control;

import at.htl.entity.Company;
import at.htl.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public Company save(Company company) {
        return getEntityManager().merge(company);
    }
}
