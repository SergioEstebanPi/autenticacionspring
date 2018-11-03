/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mac
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    //@Qualifier("usuarioService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http); //To change body of generated methods, choose Tools | Templates.
        http
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/", "/zone/public/*", "/home").permitAll()
            .antMatchers("/css/*", "/imgs/*").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
            .and()
            .logout()
            ;
        
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth); //To change body of generated methods, choose Tools | Templates.
        /*
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("test").password("test123").roles("USER").and()
            .withUser("test1").password("test123").roles("ADMIN");           
        */
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());     
    }
    
}
