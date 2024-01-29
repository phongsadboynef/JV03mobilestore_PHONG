package com.JavaBootcamp03.mobilestore.security;

//import com.JavaBootcamp03.mobilestore.filter.JwtAuthenticationFilter;
import com.JavaBootcamp03.mobilestore.filter.JwtFilter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
@NoArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomAuthenProvider customAuthenProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(customAuthenProvider)
                .build();
    }

    //Thay đổi thông tin về rule đường dẫn của Security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.sessionManagement((session) -> {
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        httpSecurity.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/login/**", "/category/**", "/images/**", "/js/**",
                                "/css/**", "/fonts/**", "/screenshot/**", "/vendor/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/product/**", "/customer/**", "/subCat/**",
                                "/role/**", "/review/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/product/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PUT, "/product/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE).hasRole("CUSTOMER")
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());

        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
