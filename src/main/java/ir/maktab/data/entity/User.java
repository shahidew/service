package ir.maktab.data.entity;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserState;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String emailAddress;

    @Column(unique = true)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserState state;

    @CreationTimestamp
    private Date date;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Column
    private Double credit;

    @Column
    private boolean isEnabled;

    public User() {
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public User setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public UserState getState() {
        return state;
    }

    public User setState(UserState state) {
        this.state = state;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public User setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public User setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getCredit() {
        return credit;
    }

    public User setCredit(Double credit) {
        this.credit = credit;
        return this;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public User setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", dateTime=" + date +
                ", userRole=" + userRole +
                '}';
    }
}
