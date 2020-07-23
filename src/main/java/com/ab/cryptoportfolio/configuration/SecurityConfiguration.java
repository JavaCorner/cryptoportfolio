package com.ab.cryptoportfolio.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Arpit Bhardwaj
 */

@Configuration
@Order(2)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //byu default the framework uses formLogin() -> usernamePasswordFilter

    //to configure only basicAuthenticationFilter
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
