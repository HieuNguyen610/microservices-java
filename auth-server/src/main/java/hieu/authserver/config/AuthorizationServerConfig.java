package hieu.authserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class AuthorizationServerConfig extends OAuth2AuthorizationServerConfiguration {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Bean
    SecurityFilterChain authorizationServerFilterChain(HttpSecurity http)
            throws Exception {
        http.with(OAuth2AuthorizationServerConfigurer.authorizationServer(),
                Customizer.withDefaults());
        return http.build();
    }
}
