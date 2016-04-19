package com.qoantum.phonebook.orm.entity;

import com.qoantum.phonebook.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Create group
 */
@Entity
@Table(name = "T_GROUP")
@Access(AccessType.FIELD)
public class Group extends AbstractEntity {

    private static final long serialVersionUID = -6501224677825947001L;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Group> subGroups;
}
