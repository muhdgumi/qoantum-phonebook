package com.qoantum.phonebook.rest;

import com.qoantum.phonebook.api.AuthRequestDto;
import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.api.SessionRequestDto;

/**
 * Authentication rest service
 */
public interface AuthenticationRestService {

    String AUTHENTICATE_USER = "/public/user/authenticate"; //POST
    String GET_USER_SESSION = "/secure/user/session"; //POST

    AuthSessionDto authenticationUser(final AuthRequestDto authRequestDto);

    AuthSessionDto getUserSession(final SessionRequestDto sessionRequestDto);
}
