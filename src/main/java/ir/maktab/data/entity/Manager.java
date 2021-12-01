package ir.maktab.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String password;

    private String emailAddress;

    public Manager() {
    }

    public Long getId() {
        return id;
    }

    public Manager setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Manager setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public Manager setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Manager setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
}
