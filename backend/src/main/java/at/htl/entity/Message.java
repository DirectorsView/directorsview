package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "DV_MES")
public class Message extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MES_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MES_SOURCE")
    private Account source;

    @Column(name = "MES_CONTENT")
    private String content;

    @Column(name = "MES_TIME")
    private LocalDate time;

    @ManyToOne
    @JoinColumn(name = "MES_CHAT")
    private Chat chat;

    public Message() {
    }

    public Message(Account source, String content, LocalDate time, Chat chat) {
        this.source = source;
        this.content = content;
        this.time = time;
        this.chat = chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", source=" + source +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", chat=" + chat +
                '}';
    }
}
