package com.uniovi.sdientrega173;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*
        @Autowired
        private UserDetailsService userDetailsService;
    */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailure();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/images/**", "/script/**", "/", "/signup", "/login/**").permitAll()
                .antMatchers("/publication/add").hasAuthority("ROLE_USER")
                .antMatchers("/publication/list").hasAuthority("ROLE_USER")
                .antMatchers("/publication/all").hasAuthority("ROLE_ADMIN")
                .antMatchers("/publication/**").hasAuthority("ROLE_USER")
                .antMatchers("/friends/list").hasAuthority("ROLE_USER")
                .antMatchers("/friends/**").hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(authenticationSuccessHandler())
                .permitAll()
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .permitAll().logoutSuccessHandler(logoutSuccessHandler());
    }
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
*/
}
