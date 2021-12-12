package at.htl.entity;

import javax.persistence.*;
import java.util.List;


@Entity(name = "DV_COM")
@Inheritance(strategy = InheritanceType.JOINED)
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

    @JoinColumn(name = "COM_ADMINS")
    @OneToMany
    private List<Person> admins;

    public Company() {
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Company(String name, String address, List<Project> projects, List<Person> employees, List<Person> admins) {
        this.name = name;
        this.address = address;
        this.projects = projects;
        this.employees = employees;
        this.admins = admins;
    }

    public Company(String password, String email, String website, String name, String address, List<Project> projects, List<Person> employees, List<Person> admins) {
        super(password, email, website);
        this.name = name;
        this.address = address;
        this.projects = projects;
        this.employees = employees;
        this.admins = admins;
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

    public List<Person> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Person> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", projects=" + projects +
                ", employees=" + employees +
                ", admins=" + admins +
                '}';
    }
}
