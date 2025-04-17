package hieu.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthorizationServerConfig {

    @Bean
    SecurityFilterChain authorizationServerFilterChain(HttpSecurity http)
            throws Exception {

        http.with(OAuth2AuthorizationServerConfigurer.authorizationServer(),
                Customizer.withDefaults());
        return http.build();
    }
}
