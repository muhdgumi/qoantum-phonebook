package com.qoantum.phonebook.service;

import com.qoantum.phonebook.orm.entity.Group;
import com.qoantum.phonebook.orm.entity.Role;
import com.qoantum.phonebook.orm.entity.User;

import java.util.Collection;

/**
 * User service
 */
public interface UserService {

    User createUser(final User user);

    User getUser(final Long userId);

    User getByUsername(final String username);

    User updateUser(final User user);

    void deleteUser(final Long userId);

    Collection<Role> getUserActiveRolesByUser(final User user);

    Collection<Group> getGroupsByUser(final User user);
}
