package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "DV_ACC")
public class Account extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACC_ID")
    private Long id;

    @Column(name = "ACC_PASSWORD")
    private String password;

    @Column(name = "ACC_EMAIL")
    private String email;

    @Column(name = "ACC_WEBSITE")
    private String website;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
