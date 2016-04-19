package com.qoantum.phonebook.remote.impl;

import com.qoantum.phonebook.api.UserDto;
import com.qoantum.phonebook.converter.UserConverter;
import com.qoantum.phonebook.orm.entity.User;
import com.qoantum.phonebook.remote.UserRemoteService;
import com.qoantum.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Remote service implementation
 */
@Service
public class UserRemoteServiceImpl implements UserRemoteService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto createUser(UserDto userDto) {

        final User convertUser = userConverter.convert(userDto);
        final User savedUser = userService.createUser(convertUser);
        return userConverter.convert(savedUser);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public UserDto getUser(Long userId) {
        User user = Optional.ofNullable(userService.getUser(userId))
                .orElseThrow(() -> new NullPointerException("User doesn't exist"));
        return userConverter.convert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto updateUser(UserDto userDto) {

        final User user = userConverter.convert(userDto);
        user.setId(userDto.getId());
        final User updatedUser = userService.updateUser(user);
        return userConverter.convert(updatedUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Long userId) {
        userService.deleteUser(userId);
    }
}
