package com.ysf.security.config;

import com.ysf.security.exceptionHandling.CustomAccessDeniedHandler;
import com.ysf.security.exceptionHandling.CustomBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/* Created by yusufulku,20.05.2025 */
@Configuration
@Profile("!prod")
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .requiresChannel(rch -> rch.anyRequest().requiresInsecure())//only HTTP
                .csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                        .requestMatchers("/notices", "/contact", "/error", "/register").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(hbc->hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(eh->eh.accessDeniedHandler(new CustomAccessDeniedHandler()));
        return http.build();
    }



    //--------- InMemoryUserDetailsManager ---------//
    //bu kısım uygulamamnın hafızasında credenitials bilgilerini tutar
    //amacımız hızlı bir uygualma yapıp login işlemini security kısmına bırakmaktır.
    //uygulama her ayağa kalktığında başa dönülür ve bilgi depolamaz, uygulamanın belleğini kullanır.
    // belli kısımda kullanıldı storage sistem kullanıldığı için yorum satırına alıyorum
//    @Bean
//    public UserDetailsService userDetailService(){
//        UserDetails user= User.withUsername("user").password("{noop}123").roles("read").build();
//        UserDetails admin= User.withUsername("admin").password("{bcrypt}$2a$12$ykKQpRy57O4RNMFaG4L9uu5CUlBTC0JBw938/x9Ip9QsIaryj6yLi").roles("admin").build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }


    //bu kısım jdbc ile işlem yapar ama biz JPA kullanmaya başladığımız için  kullanmıyoruz
   /* public UserDetailsService userDetailService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



}
