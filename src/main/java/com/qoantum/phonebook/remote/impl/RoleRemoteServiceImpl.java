package com.qoantum.phonebook.remote.impl;

import com.qoantum.phonebook.api.RoleDto;
import com.qoantum.phonebook.converter.RoleConverter;
import com.qoantum.phonebook.orm.entity.Role;
import com.qoantum.phonebook.remote.RoleRemoteService;
import com.qoantum.phonebook.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Remote service implementation
 */
@Service
public class RoleRemoteServiceImpl implements RoleRemoteService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public RoleDto createRole(RoleDto roleDto) {

        final Role role = roleConverter.convert(roleDto);
        final Role savedRole = roleService.createRole(role);
        return roleConverter.convert(savedRole);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RoleDto getRole(Long roleId) {
        return roleConverter.convert(roleService.getRole(roleId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public RoleDto updateRole(RoleDto roleDto) {

        final Role role = roleConverter.convert(roleDto);
        role.setId(roleDto.getId());
        final Role updatedRole = roleService.updateRole(role);
        return roleConverter.convert(updatedRole);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRole(Long roleId) {
        roleService.deleteRole(roleId);
    }
}
