package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.orm.entity.User;
import com.qoantum.phonebook.orm.repository.UserRepository;
import com.qoantum.phonebook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User service implementation
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }
}
