package com.qoantum.phonebook.rest;

import com.qoantum.phonebook.api.UserDto;

/**
 * Rest service
 */
public interface UserRestService {

    String USER_BASE = "/users";
    String USER_ID = "/{userId}";
    String USER_BASE_USER_ID = USER_BASE + USER_ID;

    UserDto createUser(final UserDto userDto);

    UserDto getUser(final Long userId);

    UserDto updateUser(final UserDto userDto);

    void deleteUser(final Long userId);

}
