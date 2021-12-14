package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "DV_PM")
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PM_PROJECT")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "PM_PERSON")
    private Person person;

    public ProjectMember() {
    }

    public ProjectMember(Long id, Project project, Person person) {
        this.id = id;
        this.project = project;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ProjectMember{" +
                "id=" + id +
                ", project=" + project +
                ", person=" + person +
                '}';
    }
}
