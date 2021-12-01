package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserState;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto extends UserDto {

    private List<OrderDto> orderDtos = new ArrayList<>();
    private List<CommentDto> commentDtos = new ArrayList<>();

    public CustomerDto() {
        setUserRole(UserRole.Customer);
    }


    public List<OrderDto> getOrderDtos() {
        return orderDtos;
    }

    public CustomerDto setOrderDtos(List<OrderDto> orderDtos) {
        this.orderDtos = orderDtos;
        return this;
    }

    public List<CommentDto> getCommentDtos() {
        return commentDtos;
    }

    public CustomerDto setCommentDtos(List<CommentDto> commentDtos) {
        this.commentDtos = commentDtos;
        return this;
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

    @Override
    public String toString() {
        return "CustomerDto{" +
                "fullName" + getFullName() +
                "emailAddress" + getEmailAddress() +
                "date" + getDate() +
                "credit" + getCredit() +
                "state" + getState() +
                "orderDtos=" + orderDtos +
                ", commentDtos=" + commentDtos +
                '}';
    }
}
