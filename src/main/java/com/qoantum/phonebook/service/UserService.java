package com.qoantum.phonebook.service;

import com.qoantum.phonebook.orm.entity.User;

/**
 * User service
 */
public interface UserService {

    User createUser(final User user);

    User getUser(final Long userId);

    User updateUser(final User user);

    void deleteUser(final Long userId);
}
