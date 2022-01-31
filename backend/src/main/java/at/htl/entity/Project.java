package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DV_PRO")
public class Project extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long id;

    @Column(name = "PRO_NAME")
    private String name;

    @Column(name = "PRO_DECRIPTION")
    private String description;

    @Column(name = "PRO_STARTTIME")
    LocalDate startTime;

    @Column(name = "PRO_ENDTIME")
    LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "PRO_COMPANY")
    private Company company;

    public Project() {
    }

    public Project(String name, String description, LocalDate startTime, LocalDate endTime, Company company) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.company = company;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", company=" + company +
                '}';
    }
}
