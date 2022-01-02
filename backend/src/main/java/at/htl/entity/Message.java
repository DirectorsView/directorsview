package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DV_MES")
public class Message extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MES_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MES_DESTINATION")
    private Account destination;

    @ManyToOne
    @JoinColumn(name = "MES_SOURCE")
    private Account source;

    @Column(name = "MES_CONTENT")
    private String content;

    @Column(name = "MES_TIME")
    private Timestamp time;

    public Message() {
    }

    public Message(Long id, Account destination, Account source, String content, Timestamp time) {
        this.id = id;
        this.destination = destination;
        this.source = source;
        this.content = content;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    public Account getSource() {
        return source;
    }

    public void setSource(Account source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", destination=" + destination +
                ", source=" + source +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
