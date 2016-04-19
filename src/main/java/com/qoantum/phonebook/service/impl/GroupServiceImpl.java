package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.orm.entity.Group;
import com.qoantum.phonebook.orm.repository.GroupRepository;
import com.qoantum.phonebook.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Group service implementation
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Group getGroup(Long groupId) {
        return groupRepository.findOne(groupId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteGroup(Long groupId) {
        groupRepository.delete(groupId);
    }
}
