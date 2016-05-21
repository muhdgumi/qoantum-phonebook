package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.common.RecordStatus;
import com.qoantum.phonebook.orm.entity.*;
import com.qoantum.phonebook.orm.repository.GroupMemberRepository;
import com.qoantum.phonebook.orm.repository.UserRepository;
import com.qoantum.phonebook.orm.repository.UserRoleRepository;
import com.qoantum.phonebook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * User service implementation
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private GroupMemberRepository groupMemberRepository;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getByUsername(final String username) {
        return userRepository.findByUsername(username);
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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<Role> getUserActiveRolesByUser(final User user) {
        return userRoleRepository.findByUser(user)
                .stream()
                .filter(userRole -> userRole.getRecordStatus().equals(RecordStatus.ACTIVE))
                .map(UserRole::getRole).collect(Collectors.toList());
    }

    @Override
    public Collection<Group> getGroupsByUser(User user) {
        return groupMemberRepository.findByUser(user)
                .stream()
                .filter(groupMember -> groupMember.getRecordStatus().equals(RecordStatus.ACTIVE))
                .map(GroupMember::getGroup).collect(Collectors.toList());
    }
}
