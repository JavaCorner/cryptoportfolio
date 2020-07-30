package com.ab.cryptoportfolio.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author Arpit Bhardwaj
 */
public class SecurityConfiguration3 {}

/*
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration3 extends WebSecurityConfigurerAdapter {

    private final DataSource datasource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/register", "/login").permitAll()
                .antMatchers("/support/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and().formLogin();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(this.dataSource);

        auth
                .jdbcAuthentication()
                .withDefaultSchema()
                .withUser("dave")
                .password("password");

        auth
                .jdbcAuthentication()
                .usersByUsernameQuery("select username, password from users")
                .authoritiesByUsernameQuery("select username, authorities from auth")
                .dataSource(this.dataSource);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        DelegatingPasswordEncoder encoder =  (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

}*/
