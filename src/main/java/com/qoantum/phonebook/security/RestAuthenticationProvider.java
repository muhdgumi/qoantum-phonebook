package com.qoantum.phonebook.security;

import com.qoantum.phonebook.api.AuthSessionDto;
import com.qoantum.phonebook.exception.TokenNotFoundException;
import com.qoantum.phonebook.exception.TokenNotValidException;
import com.qoantum.phonebook.service.SessionCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Authentication provider for rest service
 */
@Slf4j
//@Profile("!DEV")
@Component
public class RestAuthenticationProvider implements TokenAuthenticationProvider {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private SessionCacheService sessionCacheService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication.getPrincipal() == null) {
            throw new TokenNotFoundException();
        }

        final String token = (String) authentication.getPrincipal();
        log.debug("Authenticating with token: {}", token);

        final AuthSessionDto authSessionDto = createSession(token);

        return new QoantumAuthentication(authSessionDto);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private AuthSessionDto createSession(final String token) {

        //This is not the appropriate way of doing this if you are developing
        //micro-services. There should be cyclic dependency in the application
        //so for that reason, the session cache service is not in the same layer
        //with the provider, it then better to get the session through http
        //with the help of rest template as shown below in the commented code.
        final AuthSessionDto authSessionDto = sessionCacheService.get(token);

        //Getting session with rest template
        /*final String url = "http://localhost:7070/qoantum/phonebook/secure/user/session";
        final SessionRequestDto sessionRequestDto = new SessionRequestDto();
        sessionRequestDto.setToken(token);

        final AuthSessionDto authSessionDto = restTemplate.postForObject(url, sessionRequestDto, AuthSessionDto.class);*/

        if (authSessionDto == null) {

            log.debug("Session not found for token: {}", token);
            throw new TokenNotValidException(token);
        }

        return authSessionDto;
    }
}
