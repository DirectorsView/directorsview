package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DV_VAC")
public class Vacancy extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VAC_ID")
    private Long id;

    @Column(name = "VAC_TITLE")
    private String title;

    @Column(name = "VAC_DESCRIPTION")
    private String description;

    @Column(name = "VAC_DEADLINE")
    private LocalDate deadline;

    @Column(name = "VAC_OPENED")
    private Boolean opened;

    @ManyToOne
    @JoinColumn(name = "VAC_COMPANY")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "VAC_PROJECT")
    private Project project;

    public Vacancy() {
    }

    public Vacancy(String title, String description, LocalDate deadline, Boolean opened, Company company, Project project) {
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.opened = opened;
        this.company = company;
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                ", opened=" + opened +
                ", company=" + company +
                ", project=" + project +
                '}';
    }
}
