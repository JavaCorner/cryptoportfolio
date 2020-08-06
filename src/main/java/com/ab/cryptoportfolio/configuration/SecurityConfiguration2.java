package com.ab.cryptoportfolio.configuration;

import com.ab.cryptoportfolio.userdetails.AdditionalAuthenticationDetailsSource;
import com.ab.cryptoportfolio.userdetails.AdditionalAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author Arpit Bhardwaj
 */

/*
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration2 extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdditionalAuthenticationProvider additionalProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        */
/*http
                .authorizeRequests()
                .antMatchers("/register", "/login").permitAll()
                .antMatchers("/support/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();*//*


        http
                .authorizeRequests().antMatchers("/register", "/login", "/login-error", "/login-verified", "/verify/email", "/qrcode").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .authenticationDetailsSource(new AdditionalAuthenticationDetailsSource());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(additionalProvider);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        DelegatingPasswordEncoder encoder =  (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        encoder.setDefaultPasswordEncoderForMatches(new BCryptPasswordEncoder());
        return encoder;
    }
}
*/

public class SecurityConfiguration2{}
