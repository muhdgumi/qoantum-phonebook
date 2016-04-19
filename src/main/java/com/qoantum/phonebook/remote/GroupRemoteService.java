package com.qoantum.phonebook.remote;

import com.qoantum.phonebook.api.GroupDto;

/**
 * Remote service
 */
public interface GroupRemoteService {

    GroupDto createGroup(final GroupDto groupDto);

    GroupDto getGroup(final Long groupId);

    GroupDto updateGroup(final GroupDto groupDto);

    void deleteGroup(final Long groupId);
}
