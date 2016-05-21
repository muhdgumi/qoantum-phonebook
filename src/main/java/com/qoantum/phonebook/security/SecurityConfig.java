package com.qoantum.phonebook.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .httpBasic().and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/qoantum/phonebook/users", "/qoantum/phonebook/roles", "/qoantum/phonebook/groups").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/qoantum/phonebook/users", "/qoantum/phonebook/roles","/qoantum/phonebook/groups").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PATCH, "/qoantum/phonebook/users", "/qoantum/phonebook/roles","/qoantum/phonebook/groups").hasRole("ADMIN")
                    .antMatchers("/users*", "/roles*", "/groups*").hasRole("USER").and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth
                .inMemoryAuthentication()
                .withUser("bello").password("bello").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
}
