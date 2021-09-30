package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Gear extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String title;

    @JoinColumn
    @ManyToOne
    TimeRange timeRange;

    public Gear() {
    }

    public Gear(String title, TimeRange timeRange) {
        this.title = title;
        this.timeRange = timeRange;
    }

    public Gear(Long id, String title, TimeRange timeRange) {
        this.id = id;
        this.title = title;
        this.timeRange = timeRange;
    }
}
