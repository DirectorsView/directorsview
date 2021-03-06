package at.htl.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DV_PER")
@NamedQueries({
        @NamedQuery(name = "Person.findProjects",
                query = "select pm.project from ProjectMember pm where pm.person.id = :personId")
})
public class Person extends Account {
    @Column(name = "PER_FIRSTNAME")
    private String firstName;

    @Column(name = "PER_LASTNAME")
    private String lastName;

    @Column(name = "PER_BIRTHDATE")
    private LocalDate birthdate;

    public Person() {
    }

    public Person(String password, String email, String website, String firstName, String lastName, LocalDate birthdate) {
        super(password, email, website);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}