package com.qoantum.phonebook.remote;

import com.qoantum.phonebook.api.RoleDto;

/**
 * Remote service
 */
public interface RoleRemoteService {

    RoleDto createRole(final RoleDto roleDto);

    RoleDto getRole(final Long roleId);

    RoleDto updateRole(final RoleDto roleDto);

    void deleteRole(final Long roleId);
}
