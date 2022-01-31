package at.htl.entity;

import javax.persistence.*;


@Entity
@Table(name = "DV_COM")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Company.findProjects", query = "select p from Project p where p.company.id = :companyId")
})
public class Company extends Account {
    @Column(name = "COM_NAME")
    private String name;

    @Column(name = "COM_ADDRESS")
    private String address;

    public Company() {
    }

    public Company(String password, String email, String website, String name, String address) {
        super(password, email, website);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}