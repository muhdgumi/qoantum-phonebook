package com.qoantum.phonebook.converter;

import com.qoantum.phonebook.api.UserDto;
import com.qoantum.phonebook.common.RecordStatus;
import com.qoantum.phonebook.orm.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserConverter {

    public User convert(UserDto userDto) {

        final User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setStartOfUse(new Date());
        user.setRecordStatus(RecordStatus.ACTIVE);

        return user;
    }

    public UserDto convert(User user) {

        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setStartOfUser(user.getStartOfUse());
        userDto.setEndOfUser(user.getEndOfUse());

        return userDto;
    }
}
