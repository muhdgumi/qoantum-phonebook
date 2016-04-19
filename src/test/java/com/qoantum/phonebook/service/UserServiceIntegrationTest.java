package com.qoantum.phonebook.service;

import com.qoantum.phonebook.common.RecordStatus;
import com.qoantum.phonebook.orm.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * User service test
 */
public class UserServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest() {

        final User user = getUser();
        final User savedUser = userService.createUser(user);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals("bello", savedUser.getFirstName());
        Assert.assertEquals("muhammad", savedUser.getLastName());
    }


    private User getUser() {

        final User user = new User();
        user.setFirstName("bello");
        user.setLastName("muhammad");
        user.setUsername("bello.muhammed");
        user.setPassword("password");
        user.setDateOfBirth(new Date());
        user.setEmail("bello.muhammed@gmail.com");
        user.setStartOfUse(new Date());
        user.setRecordStatus(RecordStatus.ACTIVE);

        return user;
    }

}
