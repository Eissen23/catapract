package com.phuc.catapract.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 150)
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column
    private String password;
}
