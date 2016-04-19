package com.qoantum.phonebook.rest.impl;

import com.qoantum.phonebook.api.UserDto;
import com.qoantum.phonebook.remote.UserRemoteService;
import com.qoantum.phonebook.rest.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    private UserRemoteService userRemoteService;

    @Override
    @ResponseBody
    @RequestMapping(
            path = USER_BASE,
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userRemoteService.createUser(userDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = USER_BASE_USER_ID,
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserDto getUser(@NotNull @PathVariable Long userId) {
        return userRemoteService.getUser(userId);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = USER_BASE,
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserDto updateUser(@Valid @RequestBody UserDto userDto) {
        return userRemoteService.updateUser(userDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = USER_BASE_USER_ID,
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void deleteUser(@NotNull @PathVariable Long userId) {
        userRemoteService.deleteUser(userId);
    }
}
