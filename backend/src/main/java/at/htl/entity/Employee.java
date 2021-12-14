package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Employee extends PanacheEntityBase {

    private Long id;

    private Person person;

    private Company company;

    private Boolean isAdmin;
}
