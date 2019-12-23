/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Chukwudi Ugorji
 */
//the two line below containg @Configuration and @EnableWebSecurity was commented 
//because we can't have 2 configuration classes 
//BasicAuthenticationConfig and JWTWebSecurityConfig in package com.technologyz.stealth.jwt.config
//extending WebSecurityConfigurerAdapter
//to use basic authentication, uncomment both lines below and comment 
//@Configuration, @EnableWebSecurity and @EnableGlobalMethodSecurity(prePostEnabled = true)
//in JWTWebSecurityConfig

//@Configuration //this tells spring boot that this is a configuration file
//@EnableWebSecurity //this enables security and tells springboot that this will be our web api security class
public class BasicAuthenticationConfig extends WebSecurityConfigurerAdapter {
    
    @Override//this is saying though we know the parent class WebSecurityConfigurerAdapter(which by default enables form authentication)
    //has this configure mathod already defined, we would like/prefer to create and use our own configure method below
    public void configure(HttpSecurity http) throws Exception{
        //cors() method will add the Spring-provided CorsFilter to the application context which in turn bypasses the authorization checks for OPTIONS requests
        http
                //.cors().and()//we want cors to be enabled for all pre-flight
                .csrf().disable()//we want to disable cross site request forgery
                .authorizeRequests()//we want to authorize all request
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()//permit all request coming with the http options to all url(/**) in this api
                .anyRequest().authenticated()//authenticate any other request apart from the ones permitted above,
                //.and().formLogin()//using form login authentication or
                .and().httpBasic();//using http basic authentication
    }
}
