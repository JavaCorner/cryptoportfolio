package com.ab.cryptoportfolio.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

/**
 * @author Arpit Bhardwaj
 */

/*@Configuration
//@Order(2)
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
        //to allow framing in same domain
        http.headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();

        //to allow framing in wide domain
        http.headers().frameOptions().disable()
                .addHeaderWriter(new StaticHeadersWriter("X-FRAME-OPTIONS", "ALLOW-FROM yourdomain.com")).and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();

        //to disable content type header
        http.headers().contentTypeOptions().disable().and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();

        //to disable csrf
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();

        //to place csrf in request instead of cookie
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}*/
public class SecurityConfiguration{}
