package com.qoantum.phonebook.orm.entity;

import com.qoantum.phonebook.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * User roles
 */
@Getter
@Setter
@Entity
@Access(AccessType.FIELD)
@Table(name = "T_USER_ROLE")
public class UserRole extends AbstractEntity {

    private static final long serialVersionUID = -8106999794499414559L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Role role;
}
