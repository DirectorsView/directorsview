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

    @JoinColumn(name = "COM_INVENTORY")
    @OneToMany
    private List<Gear> inventory;

    //private List<Vacancy> vacancies;

    public Company() {
    }

    public Company(String name, String address, List<Project> projects, List<Gear> inventory) {
        this.name = name;
        this.address = address;
        this.projects = projects;
        this.inventory = inventory;
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

    public List<Gear> getInventory() {
        return inventory;
    }

    public void setInventory(List<Gear> inventory) {
        this.inventory = inventory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", projects=" + projects +
                ", inventory=" + inventory +
                '}';
    }
}
