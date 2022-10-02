/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdd.configs.handlers.LoginSuccessHandler;
import com.tdd.configs.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tdd.repository",
    "com.tdd.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutHandler;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");

        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
//        http.formLogin().successHandler(this.loginSuccessHandler);
//
////        http.logout().logoutSuccessUrl("/login");
//        http.logout().logoutSuccessHandler(this.logoutHandler);
//
//        http.exceptionHandling()
//                .accessDeniedPage("/login?accessDenied");
//
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/order/**")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//                .antMatchers("/register/shipper")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SHIPPER')")
//                .antMatchers("/shipper/**")
//                .access("hasAnyRole('ROLE_SHIPPER', 'ROLE_ADMIN')")
//                .antMatchers("/admin/**")
//                .access("hasRole( 'ROLE_ADMIN')");
//
        http.csrf().disable();
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
    
    @Bean
    public LogoutSuccessHandler logoutHandler(){
        return new LogoutHandler();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dzexh0fxv",
                "api_key", "954198583274357",
                "api_secret", "2GWmqHcb6Gwj7cmV1TE_tg1PIMM",
                "secure", true));

        return cloudinary;
    }

}
