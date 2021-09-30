package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "accountSeq"
        , sequenceName = "V_ACCOUNT_SEQ"
        , initialValue = 5000
)
public class Account extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSeq")
    Long id;
}
