package com.phuc.catapract.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue
    private Integer Id;

    @Column(length = 150)
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {
    };

    public Account(String fullName, String email, Date dateOfBirth) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth= dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
}
