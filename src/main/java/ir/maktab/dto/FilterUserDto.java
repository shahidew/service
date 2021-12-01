package ir.maktab.dto;

import ir.maktab.data.entity.SubService;
import ir.maktab.data.enums.UserRole;

public class FilterUserDto extends BaseDto {
    private String fullName;
    private String emailAddress;
    private UserRole userRole;
    private SubService subServiceDto;
    private Double credit;

    public FilterUserDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public FilterUserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public FilterUserDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public FilterUserDto setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public SubService getSubServiceDto() {
        return subServiceDto;
    }

    public FilterUserDto setSubServiceDto(SubService subServiceDto) {
        this.subServiceDto = subServiceDto;
        return this;
    }

    public Double getCredit() {
        return credit;
    }

    public FilterUserDto setCredit(Double credit) {
        this.credit = credit;
        return this;
    }

    @Override
    public String toString() {
        return "FilterUserDto{" +
                "fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", userRole=" + userRole +
                ", subServiceDto='" + subServiceDto + '\'' +
                ", credit=" + credit +
                '}';
    }
}
