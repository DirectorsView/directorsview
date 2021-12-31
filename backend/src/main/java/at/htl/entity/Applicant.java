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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", vacancy=" + vacancy +
                ", person=" + person +
                '}';
    }
}
