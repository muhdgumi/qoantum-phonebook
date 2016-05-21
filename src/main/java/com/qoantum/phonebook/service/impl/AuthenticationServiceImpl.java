package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.exception.SessionNotFoundException;
import com.qoantum.phonebook.exception.UserNotFoundException;
import com.qoantum.phonebook.orm.entity.Group;
import com.qoantum.phonebook.orm.entity.Role;
import com.qoantum.phonebook.orm.entity.User;
import com.qoantum.phonebook.service.AuthenticationService;
import com.qoantum.phonebook.service.SessionCacheService;
import com.qoantum.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.stream.Collectors;

/**
 * Authentication service
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionCacheService sessionCacheService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AuthSessionDto authenticationUser(final String username, final String password) {

        final User user = userService.getByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        //TODO: password checking will be added after adding password encryption

        final AuthSessionDto authSessionDto = createAuthSessionDto(user);
        sessionCacheService.put(authSessionDto);

        //TODO: add session logging for reference in the future
        return authSessionDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AuthSessionDto getUserSession(String token) {

        final AuthSessionDto authSessionDto = sessionCacheService.get(token);
        if (authSessionDto == null) {
            throw new SessionNotFoundException("There is not session for this token: " + token);
        }

        return authSessionDto;
    }

    private AuthSessionDto createAuthSessionDto(final User user) {

        final AuthSessionDto authSessionDto = new AuthSessionDto();
        authSessionDto.setUserId(user.getId());
        authSessionDto.setUserName(user.getUsername());
        authSessionDto.setCreatedDate(new Date());

        authSessionDto.setRoles(userService.getUserActiveRolesByUser(user)
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList()));

        authSessionDto.setGroups(userService.getGroupsByUser(user)
                .stream()
                .map(Group::getId)
                .collect(Collectors.toList()));

        return authSessionDto;
    }
}
