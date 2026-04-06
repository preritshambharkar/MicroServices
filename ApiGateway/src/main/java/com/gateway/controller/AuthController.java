package com.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final ReactiveOAuth2AuthorizedClientService clientService ;

    public AuthController(ReactiveOAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/login")
//    public ResponseEntity<AuthResponse> login(
//            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
//            @AuthenticationPrincipal OidcUser user,
//            Model model
//    ) {
//        logger.info("user email = "+ user.getEmail());
//
//        AuthResponse authResponse = new AuthResponse();
//        authResponse.setUserid(user.getEmail());
//        authResponse.setAccessToken(client.getAccessToken().getTokenValue());
//        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
//        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
//        List<String> authorities = user.getAuthorities().stream().map(grantedAuthority -> {
//            return grantedAuthority.getAuthority();
//        }).collect(Collectors.toList());
//        authResponse.setAuthories(authorities);
//
//        return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/print-token")
    public Mono<String> printToken(Principal principal) {

        return clientService.loadAuthorizedClient("auth0", principal.getName())
                .map(oAuth2AuthorizedClient -> {
                    OAuth2AccessToken accessToken = oAuth2AuthorizedClient.getAccessToken();
                    return accessToken.getTokenValue();
                })
                .defaultIfEmpty("No access token found");
    }
}
