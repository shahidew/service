package ir.maktab.dto;

import ir.maktab.data.entity.ImageFile;
import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserState;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExpertDto extends UserDto {

    private List<SubServiceDto> subServiceDtos = new ArrayList<>();
    private List<CommentDto> comments = new ArrayList<>();
    private List<OfferDto> offers = new ArrayList<>();
    private List<OrderDto> orders = new ArrayList<>();
    private List<ImageFile> imageFiles = new ArrayList<>();

    public ExpertDto() {
        setUserRole(UserRole.Expert);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public UserDto setId(Long id) {
        return super.setId(id);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public UserDto setFullName(String fullName) {
        return super.setFullName(fullName);
    }

    @Override
    public String getEmailAddress() {
        return super.getEmailAddress();
    }

    @Override
    public UserDto setEmailAddress(String emailAddress) {
        return super.setEmailAddress(emailAddress);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public UserDto setPassword(String password) {
        return super.setPassword(password);
    }

    @Override
    public UserState getState() {
        return super.getState();
    }

    @Override
    public UserDto setState(UserState state) {
        return super.setState(state);
    }

    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public UserDto setDate(Date date) {
        return super.setDate(date);
    }

    @Override
    public UserRole getUserRole() {
        return super.getUserRole();
    }

    @Override
    public UserDto setUserRole(UserRole userRole) {
        return super.setUserRole(userRole);
    }

    @Override
    public Double getCredit() {
        return super.getCredit();
    }

    @Override
    public UserDto setCredit(Double credit) {
        return super.setCredit(credit);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public UserDto setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    public List<SubServiceDto> getSubServiceDtos() {
        return subServiceDtos;
    }

    public ExpertDto setSubServiceDtos(List<SubServiceDto> subServiceDtos) {
        this.subServiceDtos = subServiceDtos;
        return this;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public ExpertDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public ExpertDto setOffers(List<OfferDto> offers) {
        this.offers = offers;
        return this;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public ExpertDto setOrders(List<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

    public List<ImageFile> getImageFiles() {
        return imageFiles;
    }

    public ExpertDto setImageFiles(List<ImageFile> imageFiles) {
        this.imageFiles = imageFiles;
        return this;
    }

    @Override
    public String toString() {
        return "ExpertDto{" +
                "fullName" + getFullName() +
                "emailAddress" + getEmailAddress() +
                "date" + getDate() +
                "credit" + getCredit() +
                "state" + getState() +
                "subServiceDtos=" + subServiceDtos +
                ", comments=" + comments +
                ", offers=" + offers +
                ", orders=" + orders +
                ", imageFiles=" + imageFiles +
                '}';
    }
}
