package com.qoantum.phonebook.orm.entity;

import com.qoantum.phonebook.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Role creation entity
 */
@Getter
@Setter
@Entity
@Access(AccessType.FIELD)
@Table(name = "T_ROLE")
public class Role extends AbstractEntity {

    private static final long serialVersionUID = -5010371253397577419L;

    @Column(nullable = false, length = 60, unique = true)
    private String name;
}
