package at.htl.control;

import at.htl.entity.Chat;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ChatRepository implements PanacheRepository<Chat> {
    @Transactional
    public Chat save(Chat applicant) {
        return getEntityManager().merge(applicant);
    }
}
