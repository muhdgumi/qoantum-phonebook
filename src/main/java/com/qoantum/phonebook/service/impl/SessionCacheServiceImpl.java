package com.qoantum.phonebook.service.impl;

import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.service.SessionCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache service implementation
 */
@Lazy
@Slf4j
@Service
@EnableCaching
public class SessionCacheServiceImpl implements SessionCacheService {

    //FIXME: redis should be install and configured for caching
    //@Value("#{cacheManager.getCache('sessionCache')}")
    //private Cache cache;
    final Map<String, AuthSessionDto> cache = new ConcurrentHashMap<>();

    @Override
    public String put(final AuthSessionDto authSessionDto) {

        final String token = UUID.randomUUID().toString();
        authSessionDto.setToken(token);

        log.debug("User: {} Token: {}", authSessionDto.getUserName(), token);
        cache.put(token, authSessionDto);

        return token;
    }

    @Override
    public AuthSessionDto get(final String token) {

        log.debug("Getting user session for toke: {}", token);
        //final AuthSessionDto authSessionDto = cache.get(token, AuthSessionDto.class);
        final AuthSessionDto authSessionDto = cache.get(token);
        log.debug("Authentication session {}.", (authSessionDto != null ? "FOUND" : "NOT FOUND"));

        return authSessionDto;
    }
}
