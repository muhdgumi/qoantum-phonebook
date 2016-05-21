package com.qoantum.phonebook.service;

import com.qoantum.phonebook.api.AuthSessionDto;

/**
 * Authentication service
 */
public interface AuthenticationService {

    AuthSessionDto authenticationUser(final String username, final String password);

    AuthSessionDto getUserSession(final String token);

}
