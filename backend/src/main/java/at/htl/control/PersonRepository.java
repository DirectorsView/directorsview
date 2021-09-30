package at.htl.control;

import at.htl.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PersonRepository implements PanacheRepository<Person> {
    public Person save(Person person) {
        return getEntityManager().merge(person);
    }
}
