package com.qoantum.phonebook.service;

import com.qoantum.phonebook.api.AuthSessionDto;

/**
 * Cache service
 */
public interface SessionCacheService {

    String put(AuthSessionDto authSessionDto);

    AuthSessionDto get(String token);
}
