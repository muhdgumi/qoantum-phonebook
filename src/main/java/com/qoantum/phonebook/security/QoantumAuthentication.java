package com.qoantum.phonebook.security;

import com.qoantum.phonebook.api.AuthSessionDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

/**
 * Authentication for qoantum phone book application
 */
public class QoantumAuthentication implements Authentication {


    private static final long serialVersionUID = 8630286924138156571L;

    private Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
    private AuthSessionDto authSessionDto;

    public QoantumAuthentication(final AuthSessionDto authSessionDto) {

        this.authSessionDto = authSessionDto;
        if (!authSessionDto.getRoles().isEmpty()) {
            authSessionDto.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role)));
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() { return null; }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return authSessionDto.getUserName();
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return authSessionDto.getUserName();
    }

    public Long getUserId() { return authSessionDto.getUserId(); }

    public String getToken() { return authSessionDto.getToken(); }

    public boolean isRolePresent(final String role) { return authSessionDto.isRolePresent(role); }

    public boolean isMemberOf(final Long groupId) { return authSessionDto.isMemberOf(groupId); }
}
