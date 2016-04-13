package com.qoantum.phonebook.orm;

import com.qoantum.phonebook.common.AbstractEntity;

import javax.persistence.*;

/**
 * Role creation entity
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "T_ROLE")
public class Role extends AbstractEntity {

    private static final long serialVersionUID = -5010371253397577419L;

    @Column(nullable = false, length = 60, unique = true)
    private String name;
}
