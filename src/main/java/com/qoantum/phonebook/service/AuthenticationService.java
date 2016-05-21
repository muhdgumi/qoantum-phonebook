package com.qoantum.phonebook.service;

import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.orm.entity.User;

/**
 * Authentication service
 */
public interface AuthenticationService {

    AuthSessionDto authenticationUser(final User user);

    AuthSessionDto getUserSession(final String token);

}
