package ir.maktab.data.entity;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserState;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Comment> comments = new ArrayList<>();

    public Customer() {
        super();
        setUserRole(UserRole.Customer);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public User setFullName(String fullName) {
        return super.setFullName(fullName);
    }

    @Override
    public String getEmailAddress() {
        return super.getEmailAddress();
    }

    @Override
    public User setEmailAddress(String emailAddress) {
        return super.setEmailAddress(emailAddress);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public User setPassword(String password) {
        return super.setPassword(password);
    }

    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public User setDate(Date date) {
        return super.setDate(date);
    }

    @Override
    public Double getCredit() {
        return super.getCredit();
    }

    @Override
    public User setCredit(Double credit) {
        return super.setCredit(credit);
    }

    @Override
    public UserState getState() {
        return super.getState();
    }

    @Override
    public User setState(UserState state) {
        return super.setState(state);
    }

    @Override
    public UserRole getUserRole() {
        return super.getUserRole();
    }

    @Override
    public User setUserRole(UserRole userRole) {
        return super.setUserRole(userRole);
    }


    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public User setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public List<Comment> getComments() {
        return comments;
    }

    public Customer setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Customer setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

}