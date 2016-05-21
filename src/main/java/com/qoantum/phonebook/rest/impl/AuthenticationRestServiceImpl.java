package com.qoantum.phonebook.rest.impl;

import com.qoantum.phonebook.api.AuthRequestDto;
import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.api.SessionRequestDto;
import com.qoantum.phonebook.remote.AuthenticationRemoteService;
import com.qoantum.phonebook.rest.AuthenticationRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Authentication rest service implementation
 */
@Slf4j
@Controller
public class AuthenticationRestServiceImpl implements AuthenticationRestService {

    @Autowired
    private AuthenticationRemoteService authenticationRemoteService;

    @Override
    @ResponseBody
    @RequestMapping(
            path = AUTHENTICATE_USER,
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public AuthSessionDto authenticationUser(@Valid @RequestBody final AuthRequestDto authRequestDto) {
        log.debug("Creating session for username: {} password: {}", authRequestDto.getUsername(), authRequestDto.getPassword());
        return authenticationRemoteService.authenticationUser(authRequestDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = GET_USER_SESSION,
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public AuthSessionDto getUserSession(@Valid @RequestBody final SessionRequestDto sessionRequestDto) {

        log.debug("Getting session for token: {}", sessionRequestDto.getToken());
        return authenticationRemoteService.getUserSession(sessionRequestDto);
    }
}
