package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;


public class Message extends PanacheEntityBase {
    private Long id;
    private Account destination;
    private Account source;
    private String content;
    private Timestamp time;
}
