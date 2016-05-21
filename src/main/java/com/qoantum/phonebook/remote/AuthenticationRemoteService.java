package com.qoantum.phonebook.remote;

import com.qoantum.phonebook.api.AuthRequestDto;
import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.api.SessionRequestDto;

/**
 * Authentication remote service
 */
public interface AuthenticationRemoteService {

    AuthSessionDto authenticationUser(final AuthRequestDto authRequestDto);

    AuthSessionDto getUserSession(final SessionRequestDto sessionRequestDto);
}
