package com.crida.pharm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;


    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }


       @Override
       protected void configure(HttpSecurity http) throws Exception {

           http.authorizeRequests()
//                    .antMatchers("/login", "/registration").permitAll()
//                   .antMatchers("/**").authenticated()
//                   .antMatchers("/admin/**").hasAnyRole("ADMIN")
                   .antMatchers("/**").permitAll()
                   .and()
                        .formLogin()
                        .failureForwardUrl("/login?error=true")
                        .successForwardUrl("/enterRequest")
                        .passwordParameter("password")
                        .usernameParameter("username")
                        .permitAll()
                    .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                   .and()
                        .csrf().disable();
        }



    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("swidaSuperAdmin")
                .password("swidaCorporation852456")
                .roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
           }




}























