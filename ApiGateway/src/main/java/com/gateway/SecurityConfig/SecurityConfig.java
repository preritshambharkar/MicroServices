package com.gateway.SecurityConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.server.SecurityWebFilterChain;
import java.util.function.Consumer;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${auth0.audience}")
    private String audience;

    private final ReactiveClientRegistrationRepository repository;

    public SecurityConfig(ReactiveClientRegistrationRepository repository) {
        this.repository = repository;
    }


//    @Bean
//    @SuppressWarnings("deprecation")
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//        httpSecurity
//                    .authorizeExchange()
//                    .anyExchange()
//                    .authenticated()
//                    .and()
//                    .oauth2Client()
//                    .and()
//                    .oauth2ResourceServer()
//                    .jwt();
//        return httpSecurity.build();
//    }



    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
                .authorizeExchange(authorizeExchangeSpec ->
                    authorizeExchangeSpec.anyExchange().authenticated())
                .oauth2Login(oAuth2LoginSpec ->
                    oAuth2LoginSpec.authorizationRequestResolver(authorizationRequestResolver(repository)));
        return httpSecurity.build();
    }

    private ServerOAuth2AuthorizationRequestResolver authorizationRequestResolver (
            ReactiveClientRegistrationRepository repository) {
        DefaultServerOAuth2AuthorizationRequestResolver defaultOAuth2AuthorizationRequestResolver
                = new DefaultServerOAuth2AuthorizationRequestResolver(repository);
        defaultOAuth2AuthorizationRequestResolver.setAuthorizationRequestCustomizer(autBuilderCustomizer());
        return defaultOAuth2AuthorizationRequestResolver;
    }

    private Consumer<OAuth2AuthorizationRequest.Builder> autBuilderCustomizer() {
        return customizer -> customizer.additionalParameters(params -> params.put("audience", audience));
    }
}
