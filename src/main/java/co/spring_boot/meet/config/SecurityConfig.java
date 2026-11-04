package co.spring_boot.meet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/*", "/api/rest/**").hasRole("API_USER")
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/login_form").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login_form")
                .loginProcessingUrl("/login_form")
                .failureUrl("/login_form?error")
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            );

        return http.build();
    }
    
    
    //SOLO PARA PRUEBAS, NO USAR EN PRODUCCION
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("admin")
        .password(passwordEncoder().encode("123")).roles("USER", "API_USER")
        .build();
        UserDetails user1 = User.builder().username("user")
        .password(passwordEncoder().encode("123")).roles("USER")
        .build();

        return new InMemoryUserDetailsManager(user, user1);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
