package com.qoantum.phonebook.rest;

import com.qoantum.phonebook.api.GroupDto;

/**
 * Rest service
 */
public interface GroupRestService {

    String GROUP_BASE = "/groups";
    String GROUP_ID = "/{groupId}";
    String GROUP_BASE_GROUP_ID = GROUP_BASE + GROUP_ID;

    GroupDto createGroup(final GroupDto groupDto);

    GroupDto getGroup(final Long groupId);

    GroupDto updateGroup(final GroupDto groupDto);

    void deleteGroup(final Long groupId);
}
