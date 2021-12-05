package at.htl.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DV_COM")
public class Company extends Account {
    @Column(name = "COM_NAME")
    private String name;

    @Column(name = "COM_ADRESS")
    private String adress;

    @JoinColumn(name = "COM_PROJECTS")
    @OneToMany
    private List<Project> projects;

    @JoinColumn(name = "COM_INVENTORY")
    @OneToMany
    private List<Gear> inventory;

    //private List<Vacancy> vacancies;

    public Company() {
    }

    public Company(String name, String adress, List<Project> projects, List<Gear> inventory) {
        this.name = name;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
