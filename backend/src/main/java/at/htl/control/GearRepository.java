package at.htl.control;

import at.htl.entity.Gear;
import at.htl.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class GearRepository implements PanacheRepository<Gear> {
    public Gear save(Gear gear) {
        return getEntityManager().merge(gear);
    }
}
