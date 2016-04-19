package com.qoantum.phonebook.converter;

import com.qoantum.phonebook.api.GroupDto;
import com.qoantum.phonebook.common.RecordStatus;
import com.qoantum.phonebook.orm.entity.Group;
import com.qoantum.phonebook.orm.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    @Autowired
    private GroupRepository groupRepository;

    public Group convert(GroupDto groupDto) {

        final Group group = new Group();
        group.setName(groupDto.getName());
        group.setParent(setGroupParent(groupDto.getParentId()));
        group.setRecordStatus(RecordStatus.ACTIVE);

        return group;
    }

    public GroupDto convert(Group group) {

        final GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setParentId(group.getParent().getId());

        //TODO: set group ids for dto

        return groupDto;
    }

    private Group setGroupParent(Long id) {

        Group gp = groupRepository.findOne(id);
        if (gp == null) {
            throw new NullPointerException("Group doesn't exists with id: " + id);
        }
        return gp;
    }
}
