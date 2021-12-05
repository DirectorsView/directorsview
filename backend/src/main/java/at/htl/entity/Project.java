package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.Constraint;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Project extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    LocalDate startTime;

    @Column
    LocalDate endTime;

    @JoinColumn
    @OneToMany
    private List<Person> employees;

    public Project() {
    }

    public Project(LocalDate startTime, LocalDate endTime, List<Person> employees) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }
}
