/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.model;
import java.util.Date;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;
/**
 *
 * @author rayhan-andika
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    
    private String email;
    private String username;
    private String password;
    private String fullName;
    private Date createdDate;

    public User() {}

    public User(String email, String username, String password, 
            String fullName, Date createdDate) {
        
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.createdDate = createdDate;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID:- " + getId() + 
                ", username:- " + getUsername() + 
                ", password:- " + getPassword() +
                ", email:- " + getEmail() +
                ", fullname:- " + getFullName() +
                ", createdDate:- " + getCreatedDate().toString());
        return str.toString();
    }
}