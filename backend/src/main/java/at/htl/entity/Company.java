package at.htl.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DV_COM")
public class Company extends Account {
    @Column(name = "COM_NAME")
    private String name;

    @Column(name = "COM_ADDRESS")
    private String address;

    @JoinColumn(name = "COM_PROJECTS")
    @OneToMany
    private List<Project> projects;

    //private List<Vacancy> vacancies;

    @JoinColumn(name = "COM_EMPLOYEES")
    @OneToMany
    private List<Person> employees;

    public Company() {
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }
}
