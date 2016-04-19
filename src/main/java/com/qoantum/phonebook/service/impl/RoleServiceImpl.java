package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.orm.entity.Role;
import com.qoantum.phonebook.orm.repository.RoleRepository;
import com.qoantum.phonebook.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Role service implementation
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Role getRole(Long roleId) {
        return roleRepository.findOne(roleId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRole(Long roleId) {
        roleRepository.delete(roleId);
    }
}
