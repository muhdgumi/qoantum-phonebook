package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.orm.entity.User;
import com.qoantum.phonebook.service.AuthenticationService;
import com.qoantum.phonebook.service.GroupService;
import com.qoantum.phonebook.service.RoleService;
import com.qoantum.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Authentication service
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @Override
    public AuthSessionDto authenticationUser(User user) {
        return null;
    }

    @Override
    public AuthSessionDto getUserSession(String token) {
        return null;
    }
}
