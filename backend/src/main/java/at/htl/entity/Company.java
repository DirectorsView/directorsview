package at.htl.entity;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends Account {
    @Column
    private String name;

    @JoinColumn
    @ManyToOne
    private List<Project> projects;

    @JoinColumn
    @ManyToOne
    private List<Gear> inventory;
}
