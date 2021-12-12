package at.htl.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "DV_COM")
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends Account {
    @Column(name = "COM_NAME")
    private String name;

    @Column(name = "COM_ADDRESS")
    private String address;

    /*@JoinColumn(name = "COM_EMPLOYEES")
    @OneToMany
    private List<Person> employees;

    @JoinColumn(name = "COM_ADMINS")
    @OneToMany
    private List<Person> admins;*/

    public Company() {
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Company(String name, String address, List<Person> employees, List<Person> admins) {
        this.name = name;
        this.address = address;
        //this.projects = projects;
        //this.employees = employees;
        //this.admins = admins;
    }

    public Company(String password, String email, String website, String name, String address, List<Person> employees, List<Person> admins) {
        super(password, email, website);
        this.name = name;
        this.address = address;
        //this.employees = employees;
        //this.admins = admins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public List<Person> getEmployees() {
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
    }*/

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
