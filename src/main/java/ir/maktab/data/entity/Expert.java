package ir.maktab.data.entity;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserState;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expert")
public class Expert extends User {

    @ManyToMany(targetEntity = SubService.class, cascade = CascadeType.ALL)
    private List<SubService> subServices = new ArrayList<>();

    @OneToMany(mappedBy = "expert")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "expert")
    private List<Offer> offers = new ArrayList<>();

    @OneToMany(mappedBy = "expert")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "expert")
    private List<ImageFile> imageFiles = new ArrayList<>();

    public Expert() {
        super();
        setUserRole(UserRole.Expert);
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
    public UserState getState() {
        return super.getState();
    }

    @Override
    public User setState(UserState state) {
        return super.setState(state);
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
    public UserRole getUserRole() {
        return super.getUserRole();
    }

    @Override
    public User setUserRole(UserRole userRole) {
        return super.setUserRole(userRole);
    }


    @Override
    public String toString() {
        return super.toString();
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
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public User setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Expert setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public Expert setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Expert setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public List<SubService> getSubServices() {
        return subServices;
    }

    public Expert setSubServices(List<SubService> subServices) {
        this.subServices = subServices;
        return this;
    }

    public List<ImageFile> getImageFiles() {
        return imageFiles;
    }

    public Expert setImageFiles(List<ImageFile> imageFiles) {
        this.imageFiles = imageFiles;
        return this;
    }
}

