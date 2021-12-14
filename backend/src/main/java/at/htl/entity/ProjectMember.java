package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "DV_PM")
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PM_PROJECT")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "PM_PERSON")
    private Person person;
}
