package at.htl.control;

import at.htl.entity.Person;
import at.htl.entity.Project;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class PersonRepository implements PanacheRepository<Person> {

    public Person save(Person person) {
        return getEntityManager().merge(person);
    }

    public List<Project> findProjects(Long personId) {
        return getEntityManager()
                .createNamedQuery("Person.findProjects", Project.class)
                .setParameter("personId", personId)
                .getResultList();
    }

}