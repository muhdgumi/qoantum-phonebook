package com.qoantum.phonebook.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Filter for token based authentication
 */
@Slf4j
public class AuthenticationTokenFilter extends RequestHeaderAuthenticationFilter {

    private static final String HEADER_TOKEN_KEY = "headerTokenKey";

    public AuthenticationTokenFilter(final AuthenticationManager authenticationManager) {

        setAuthenticationManager(authenticationManager);
        setExceptionIfHeaderMissing(false);
        setPrincipalRequestHeader(HEADER_TOKEN_KEY);
        setInvalidateSessionOnPrincipalChange(true);
        setCheckForPrincipalChanges(false);
        setContinueFilterChainOnUnsuccessfulAuthentication(false);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            super.doFilter(request, response, chain);
        } catch (AuthenticationException e) {
            //TODO: to be continued
        }
    }
}
