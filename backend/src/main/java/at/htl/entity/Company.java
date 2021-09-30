package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends PanacheEntityBase {
    @Column
    private String name;

    @JoinColumn
    @OneToMany
    private List<Project> projects;

    @JoinColumn
    @OneToMany
    private List<Gear> inventory;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Company() {
    }

    public Company(String name, List<Project> projects, List<Gear> inventory) {
        this.name = name;
        this.projects = projects;
        this.inventory = inventory;
    }
}
