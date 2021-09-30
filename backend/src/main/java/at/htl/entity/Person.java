package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Person extends Account {
    @Column
    String firstName;

    @Column
    String lastName;
}
