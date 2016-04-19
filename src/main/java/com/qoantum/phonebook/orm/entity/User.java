package com.qoantum.phonebook.orm.entity;

import com.qoantum.phonebook.common.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * User entity
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "T_USER")
public class User extends AbstractEntity {

    private static final long serialVersionUID = -5620803131598954200L;

    @Column(nullable = false, length = 60)
    private String firstName;

    @Column(nullable = false, length = 60)
    private String lastName;

    @Column(nullable = false, length = 60, unique = true)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startOfUser;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endOfUser;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getStartOfUser() {
        return startOfUser;
    }

    public void setStartOfUser(Date startOfUser) {
        this.startOfUser = startOfUser;
    }

    public Date getEndOfUser() {
        return endOfUser;
    }

    public void setEndOfUser(Date endOfUser) {
        this.endOfUser = endOfUser;
    }
}
