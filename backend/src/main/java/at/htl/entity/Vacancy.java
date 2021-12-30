package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DV_VAC")
public class Vacancy extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VAC_ID")
    private Long id;

    @Column(name = "VAC_TITLE")
    private String title;

    @Column(name = "VAC_DEADLINE")
    private LocalDate deadline;

    @Column(name = "VAC_OPENED")
    private Boolean opened;

    @ManyToOne
    @JoinColumn(name = "VAC_COMPANY")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "VAC_PROJECT")
    private Project project;
}
