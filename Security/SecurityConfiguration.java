package com.ehayes.springit2.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//turned on secured annotation in vote controller
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }
    //The default configuration below:
    //Ensures that any request to our application requires the user to be authenticated
    //Allows users to authenticate with form based login

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //Remember that rules are read top down
           .authorizeRequests()

                .requestMatchers(EndpointRequest.to("info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                .antMatchers("/actuator/").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/link/submit").hasRole("USER")
           .and()
           .formLogin()
                .loginPage("/login")
           .permitAll()
            .usernameParameter("email")
            .and()
            .logout()
        //cookie based approaced to remember me
            .and()
            .rememberMe()
            .and()
            .csrf().disable()
            .headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
