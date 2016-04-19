package com.qoantum.phonebook.remote;

import com.qoantum.phonebook.api.UserDto;

/**
 * Remote service
 */
public interface UserRemoteService {

    UserDto createUser(final UserDto userDto);

    UserDto getUser(final Long userId);

    UserDto updateUser(final UserDto userDto);

    void deleteUser(final Long userId);
}
