package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TimeRange extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    LocalDate startTime;
    @Column
    LocalDate endTime;

    public TimeRange() {
    }

    public TimeRange(LocalDate startTime, LocalDate endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeRange(Long id, LocalDate startTime, LocalDate endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
