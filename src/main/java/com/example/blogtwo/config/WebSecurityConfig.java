package com.example.blogtwo.config;

import com.example.blogtwo.service.BlogUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new BlogUserDetailsService();
    };
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**", "/registration","/login")// allow/permit non authenticated user for these routes
                .permitAll()
                .anyRequest().authenticated()//any other route is, you must be authenticated
                .and()
                .formLogin()//We are using form login,
                .loginPage("/login")//The route to access  login page, where user are redirected to when not logged in, check AuthController,
                .passwordParameter("password")//the field submited as password field in the form, check this in login.html
                .usernameParameter("email")//the field we will use as username field,check this in login.html
                .and()
                .logout().permitAll().logoutSuccessUrl("/login?logout=true")
                .and()
                .csrf().disable();
    }
}