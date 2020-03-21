package com.codingfairy.web.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Server security config
 * @author cuihao
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthSecurity authSecurity;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(authSecurity);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/receive/**").permitAll()
                .antMatchers("/api/v1/auth").permitAll()
                .antMatchers("/api/v1/auth/register").permitAll()
                .antMatchers("/api/v1/result/**").permitAll()
                .antMatchers("/api/v1/**").authenticated()
                .antMatchers("/api/v1/activeness/**").access("hasAuthority('USER')")
                .antMatchers("/api/v1/flow/**").access("hasAuthority('USER')")
                .antMatchers("/api/v1/newOld/**").access("hasAuthority('USER')")
                .antMatchers("/api/v1/storeHour/**").access("hasAuthority('USER')")
                .antMatchers("/api/v1/visitCircle/**").access("hasAuthority('USER')")
                .antMatchers("/api/v1/manager/**").access("hasAuthority('ADMIN')")
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .cors()
        ;
    }

}
