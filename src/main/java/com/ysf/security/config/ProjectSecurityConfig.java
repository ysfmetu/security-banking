package com.ysf.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/* Created by yusufulku,20.05.2025 */
@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests)
                ->
                        //(AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).permitAll());
                       requests.requestMatchers("/myAccount","/myCards","/myBalance","/myLoans").authenticated()
                                 .requestMatchers("/contact","/error","/notice").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }



    //--------- InMemoryUserDetailsManager ---------//
    //bu kısım uygulamamnın hafızasında credenitials bilgilerini tutar
    //amacımız hızlı bir uygualma yapıp login işlemini security kısmına bırakmaktır.
    //uygulama her ayağa kalktığında başa dönülür ve bilgi depolamaz, uygulamanın belleğini kullanır.
    @Bean
    public UserDetailsService userDetailService(){
        UserDetails user= User.withUsername("user").password("{noop}123").roles("read").build();
        UserDetails admin= User.withUsername("admin").password("{bcrypt}$2a$12$ykKQpRy57O4RNMFaG4L9uu5CUlBTC0JBw938/x9Ip9QsIaryj6yLi").roles("admin").build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
