package at.htl.control;

import at.htl.entity.Employee;
import at.htl.entity.ProjectMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ProjectMemberRepository implements PanacheRepository<ProjectMember> {

    public ProjectMember save(ProjectMember projectMember) {
        return getEntityManager().merge(projectMember);
    }

}
