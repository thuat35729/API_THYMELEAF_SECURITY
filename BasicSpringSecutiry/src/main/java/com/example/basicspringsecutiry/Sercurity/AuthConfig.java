package com.example.basicspringsecutiry.Sercurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class AuthConfig {
    // mã hóa mật khẩu
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        // Corrected query: Use 1 (true) as the enabled status
        manager.setUsersByUsernameQuery("SELECT username, password, 1 as enabled FROM users WHERE username = ?");

        // Custom query to fetch user authorities
        manager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
//        return new JdbcUserDetailsManager(dataSource);
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/home/login").loginProcessingUrl("/login") // Specify the custom login page
                        .permitAll()
                ).logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access")); // Enable HTTP Basic Authentication

        return http.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password("{noop}123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("user2")
//                .password("{noop}123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails user3 = User.builder()
//                .username("user3")
//                .password("{noop}123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }
}
