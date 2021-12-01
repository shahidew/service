package ir.maktab.dto;

import javax.validation.constraints.*;

public class ManagerDto {

    private Long id;


    @Size(min = 5, max = 40, message = "Size should be between 5 and 40")
    private String fullName;

    @Email(message = "Email has invalid format")
    @NotBlank(message = "Email should not be empty")
    private String emailAddress;

    @Pattern(regexp = "^[a-zA-Z0-8]{8}", message = "Length must be 8 and consists of letters and numbers")
    private String password;


    public ManagerDto() {
    }

    public Long getId() {
        return id;
    }

    public ManagerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public ManagerDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public ManagerDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ManagerDto setPassword(String password) {
        this.password = password;
        return this;
    }

}
