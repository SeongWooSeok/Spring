package com.springboot.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
   
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http.csrf().disable().cors().disable();
      http.authorizeHttpRequests(request -> request
            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/css/**","/js/**","/img/**").permitAll()
            .requestMatchers("/guest/**").permitAll()
            .requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated() //모든요청 인증
            );
      http.formLogin().permitAll();
      http.logout().permitAll();
      return http.build();
   }

   @Bean
   public InMemoryUserDetailsManager userDetailsService() {
      UserDetails user = User.withUsername("user")
            .password(passwordEncoder().encode("1234"))
            .roles("USER").build();
      UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder().encode("1234"))
            .roles("ADMIN").build();
      UserDetails[] userDetails = new UserDetails[2];
      userDetails[0]=user;
      userDetails[1]=admin;
      System.out.println(">> ");
      System.out.println(passwordEncoder().encode("1234"));
      System.out.println(" << ");
      return new InMemoryUserDetailsManager(userDetails);
   }

   
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
      
   }
}