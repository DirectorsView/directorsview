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

    public Employee() {
    }

    public Employee(Long id, Person person, Company company, Boolean isAdmin) {
        this.id = id;
        this.person = person;
        this.company = company;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", person=" + person +
                ", company=" + company +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
