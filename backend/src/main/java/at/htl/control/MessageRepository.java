package at.htl.control;

import at.htl.entity.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import static io.quarkus.hibernate.orm.panache.Panache.getEntityManager;

@ApplicationScoped
@Transactional
public class MessageRepository {

    public Message save(Message message) {
        return getEntityManager().merge(message);
    }
}
