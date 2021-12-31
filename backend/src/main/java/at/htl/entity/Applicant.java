package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "DV_APP")
public class Applicant extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "APP_VACANCY")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "APP_PERSON")
    private Person person;

    public Applicant() {
    }

    public Applicant(Long id, Vacancy vacancy, Person person) {
        this.id = id;
        this.vacancy = vacancy;
        this.person = person;
    }

}
