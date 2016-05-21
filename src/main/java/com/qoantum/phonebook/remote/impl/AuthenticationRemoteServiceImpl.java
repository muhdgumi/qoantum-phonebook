package com.qoantum.phonebook.remote.impl;

import com.qoantum.phonebook.api.AuthRequestDto;
import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.api.SessionRequestDto;
import com.qoantum.phonebook.remote.AuthenticationRemoteService;
import com.qoantum.phonebook.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Authentication remote service implementation
 */
@Service
public class AuthenticationRemoteServiceImpl implements AuthenticationRemoteService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AuthSessionDto authenticationUser(final AuthRequestDto authRequestDto) {
        return authenticationService.authenticationUser(authRequestDto.getUsername(), authRequestDto.getPassword());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AuthSessionDto getUserSession(final SessionRequestDto sessionRequestDto) {
        return authenticationService.getUserSession(sessionRequestDto.getToken());
    }
}
