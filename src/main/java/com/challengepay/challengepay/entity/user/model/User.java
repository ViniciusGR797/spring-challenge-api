package com.challengepay.challengepay.entity.user.model;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String document;
    private String email;
    private String password;
    private UserType userType;
    
    public User(String name, String document, String email, String password, UserType userType) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
}
