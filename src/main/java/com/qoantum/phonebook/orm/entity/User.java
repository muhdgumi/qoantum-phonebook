package com.qoantum.phonebook.orm.entity;

import com.qoantum.phonebook.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * User entity
 */
@Getter
@Setter
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
    private Date startOfUse;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date endOfUse;
}
