package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserState;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class UserDto extends BaseDto {

    private Long id;

    @NotBlank(message = "fullname.notEmpty")
    private String fullName;

    @Email(message = "email.validPattern")
    @NotBlank(message = "email.notEmpty")
    private String emailAddress;

    @Pattern(regexp = "^[a-zA-Z0-8]{8,15}", message = "password.validPattern")
    private String password;

    private UserState state;

    private Date date;

    private UserRole userRole;

    private Double credit;

    private boolean isEnabled;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public UserDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }


    public UserState getState() {
        return state;
    }

    public UserDto setState(UserState state) {
        this.state = state;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public UserDto setDate(Date date) {
        this.date = date;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public UserDto setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public Double getCredit() {
        return credit;
    }

    public UserDto setCredit(Double credit) {
        this.credit = credit;
        return this;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public UserDto setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", userRole=" + userRole +
                ", credit=" + credit +
                '}';
    }
}
