package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "DV_APP")
public class Applicant {

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
}
