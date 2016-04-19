package com.qoantum.phonebook.service;

import com.qoantum.phonebook.orm.entity.Group;

/**
 * Group service
 */
public interface GroupService {

    Group createGroup(final Group group);

    Group getGroup(final Long groupId);

    Group updateGroup(final Group group);

    void deleteGroup(final Long groupId);
}
