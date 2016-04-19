package com.qoantum.phonebook.converter;

import com.qoantum.phonebook.api.RoleDto;
import com.qoantum.phonebook.common.RecordStatus;
import com.qoantum.phonebook.orm.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role convert(RoleDto roleDto) {

        final Role role = new Role();
        role.setName(role.getName());
        role.setRecordStatus(RecordStatus.ACTIVE);

        return role;
    }

    public RoleDto convert(Role role) {

        final RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());

        return roleDto;
    }
}
