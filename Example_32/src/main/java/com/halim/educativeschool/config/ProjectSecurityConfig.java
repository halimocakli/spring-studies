package com.halim.educativeschool.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig
{
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        // By default, any request with HTTP methods that can update data like POST, PUT will be stopped with 403 error
        // due to CSRF protection. We can disable the same for now and enable it in the coming sections when we started
        // generating CSRF tokens.
        httpSecurity
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/saveMessage")
                        .ignoringRequestMatchers("/contact")
                        .ignoringRequestMatchers(PathRequest.toH2Console()))

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("holidays/**").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMessage").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/displayMessages").hasRole("ADMIN")
                        .requestMatchers("/closeMessages").hasRole("ADMIN")
                        .requestMatchers(PathRequest.toH2Console()).permitAll())

                .formLogin(loginConfigurer -> loginConfigurer
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true")
                        .permitAll())

                .logout(logoutConfigurer -> logoutConfigurer
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true).permitAll())

                .httpBasic(Customizer.withDefaults());


        httpSecurity.headers(headersConfigurer -> headersConfigurer
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return httpSecurity.build();
    }

    /*
     * When we are trying to create multiple users inside any web application, we have to store those users in some
     * storage system. The ideal production approach is to store the user details inside that database. But since we
     * have not yet introduced the database inside the course, for now, I'm going to show you how to configure multiple
     * users inside the memory of your web application itself. But please note this approach is not recommended for
     * production web application. You can only leverage this approach for any low severity applications or any POC
     * applications. When we introduce database into our web application and when we configure the same, I'm going to
     * enhance this code further so that we can store any number of users inside a storage system like database.
     * For now, since we have decided to store the users inside the InMemory of the web application, we need to create
     * a bean of InMemoryUserDetailsManager.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManagerService()
    {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    protected PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}

