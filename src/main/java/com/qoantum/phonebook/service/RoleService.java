package com.qoantum.phonebook.service;

import com.qoantum.phonebook.orm.entity.Role;

/**
 * Role service
 */
public interface RoleService {

    Role createRole(final Role role);

    Role getRole(final Long roleId);

    Role updateRole(final Role role);

    void deleteRole(final Long roleId);
}
