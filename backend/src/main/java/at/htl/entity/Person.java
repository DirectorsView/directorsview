package at.htl.entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DV_PER")
public class Person extends Account {
    @Column(name = "PER_FIRSTNAME")
    private String firstName;

    @Column(name = "PER_LASTNAME")
    private String lastName;

    @Column(name = "PER_BIRTHDATE")
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "PER_COMPANY")
    private Company company;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthdate, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.company = company;
    }

    public Person(String password, String email, String website, String firstName, String lastName, LocalDate birthdate, Company company) {
        super(password, email, website);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", company=" + company +
                '}';
    }
}
