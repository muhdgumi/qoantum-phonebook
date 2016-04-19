package com.qoantum.phonebook.rest;

import com.qoantum.phonebook.api.RoleDto;

/**
 * Rest service
 */
public interface RoleRestService {

    String ROLE_BASE = "/roles";
    String ROLE_ID = "/{roleId}";
    String ROLE_BASE_ROLE_ID = ROLE_BASE + ROLE_ID;

    RoleDto createRole(final RoleDto roleDto);

    RoleDto getRole(final Long roleId);

    RoleDto updateRole(final RoleDto roleDto);

    void deleteRole(final Long roleId);
}
