package at.htl.control;

import at.htl.entity.Person;
import at.htl.entity.Project;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProjectRepository implements PanacheRepository<Project> {
    public Project save(Project project) {
        return getEntityManager().merge(project);
    }
}
