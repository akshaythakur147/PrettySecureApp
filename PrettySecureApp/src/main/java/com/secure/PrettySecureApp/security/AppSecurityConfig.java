package com.secure.PrettySecureApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Provide a convenient security for URL Authorization
 * you can make rules so that which URL patterns should be allowed with/without
 * authorization
 * and rules so that user with proper authority can only access the URL
 */

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        // http.formLogin();
        // http.httpBasic();

        http.authorizeRequests()
                .antMatchers("/hello", "/public").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/account/**").hasAuthority("USER")// any url with prefix as account should have authority
                                                                // as USER
                .anyRequest().authenticated().and()
                .formLogin().and()
                .httpBasic();

    }

}
