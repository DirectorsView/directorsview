package at.htl.control;

import at.htl.entity.Account;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AccountRepository implements PanacheRepository<Account> {
    public Account save(Account account) {
        return getEntityManager().merge(account);
    }
}
