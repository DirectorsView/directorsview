package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "DV_EMP")
public class Employee extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EMP_PERSON")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "EMP_COMPANY")
    private Company company;

    @Column(name = "EMP_ISADMIN")
    private Boolean isAdmin;
}
