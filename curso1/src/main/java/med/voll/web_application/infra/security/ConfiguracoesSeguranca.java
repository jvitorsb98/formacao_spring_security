package med.voll.web_application.infra.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracoesSeguranca {

    @Bean
    public UserDetailsService dadosUsuariosCadastrados(){
        UserDetails user1 = User.builder()
                .username("joao@email.com")
                .password("{noop}joao123")
                .build();
        UserDetails user2 = User.builder()
                .username("maria@email.com")
                .password("{noop}maria123")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public SecurityFilterChain filtrosSeguranca(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests( req -> {
            req.requestMatchers("/css/**", "/js/**" , "/assets/**").permitAll();
            req.anyRequest().authenticated();
        }).formLogin(form -> form.loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll())
            .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll())
            .build();
    }

}
