package com.qoantum.phonebook.orm.entity;

import com.qoantum.phonebook.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Group member
 */
@Getter
@Setter
@Entity
@Access(AccessType.FIELD)
@Table(name = "T_GROUP_MEMBER")
public class GroupMember extends AbstractEntity {

    private static final long serialVersionUID = -621034114676928121L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;
}
