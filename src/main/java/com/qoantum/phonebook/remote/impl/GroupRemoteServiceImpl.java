package com.qoantum.phonebook.remote.impl;

import com.qoantum.phonebook.api.GroupDto;
import com.qoantum.phonebook.converter.GroupConverter;
import com.qoantum.phonebook.orm.entity.Group;
import com.qoantum.phonebook.remote.GroupRemoteService;
import com.qoantum.phonebook.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Remote service implementation
 */
@Service
public class GroupRemoteServiceImpl implements GroupRemoteService {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupConverter groupConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GroupDto createGroup(GroupDto groupDto) {

        final Group group = groupConverter.convert(groupDto);
        final Group savedGroup = groupService.createGroup(group);
        return groupConverter.convert(savedGroup);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public GroupDto getGroup(Long groupId) {
        return groupConverter.convert(groupService.getGroup(groupId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GroupDto updateGroup(GroupDto groupDto) {

        final Group group = groupConverter.convert(groupDto);
        group.setId(groupDto.getId());
        final Group updatedGroup = groupService.updateGroup(group);
        return groupConverter.convert(updatedGroup);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteGroup(Long groupId) {
        groupService.deleteGroup(groupId);
    }
}
