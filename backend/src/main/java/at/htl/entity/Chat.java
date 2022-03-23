package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "DV_CHA")
public class Chat extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHA_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHA_ACCOUNT1")
    private Account account1;

    @ManyToOne
    @JoinColumn(name = "CHA_ACCOUNT2")
    private Account account2;

    @Column(name = "CHA_TOKEN", unique = true)
    private String token;

    public Chat() {
    }

    public Chat(Account account1, Account account2, String token) {
        this.account1 = account1;
        this.account2 = account2;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount1() {
        return account1;
    }

    public Account getAccount2() {
        return account2;
    }

    public String getToken() {
        return token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount1(Account account1) {
        this.account1 = account1;
    }

    public void setAccount2(Account account2) {
        this.account2 = account2;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", account1=" + account1 +
                ", account2=" + account2 +
                ", token='" + token + '\'' +
                '}';
    }
}
