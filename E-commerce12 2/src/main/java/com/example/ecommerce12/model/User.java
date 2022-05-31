package com.example.ecommerce12.model;


import javax.validation.constraints.*;

import lombok.Data;

@Data
public class User {



    @NotEmpty(message = "id is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private Integer ID;

    @NotEmpty(message = "username is required")
    @Size(min = 5,max = 5,message = "Size the username is 5")
    private String username;

    @NotEmpty(message = "password is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,6}$",message = "username must be of 6 to 12 length with no special characters")
    private String password;

    @NotEmpty(message = "email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "role is required")
    @Pattern(regexp = "(Admin|Customer)",
            message = "car must be in (Admin|Customer)")
    private String role;

    @NotEmpty(message = "price is required")
    @Positive(message = "price must be positive")
    private Integer balance;


    public User(@NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
                @NotEmpty(message = "username is required") @Size(min = 5, max = 5, message = "Size the username is 5") String username,
                @NotEmpty(message = "password is required") @Pattern(regexp = "^[a-zA-Z0-9]{6,6}$", message = "username must be of 6 to 12 length with no special characters") String password,
                @NotEmpty(message = "email is required") @Email(message = "Email should be valid") String email,
                @NotEmpty(message = "role is required") String role,
                @NotEmpty(message = "price is required") @Positive(message = "price must be positive") Integer balance) {

        ID = iD;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.balance = balance;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }



}
