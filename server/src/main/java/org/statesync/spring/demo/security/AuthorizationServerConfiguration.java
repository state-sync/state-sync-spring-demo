package org.statesync.spring.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.statesync.spring.demo.entity.Role;

import java.util.stream.Stream;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value("${security.oauth2.client.app}")
    private String clientApp;

    @Value("${security.oauth2.client.secret}")
    private String clientSecret;

    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    private final AuthenticationManager authenticationManager;
    private final UserDetailService userDetailService;

    private TokenStore tokenStore = new InMemoryTokenStore();

    @Autowired
    public AuthorizationServerConfiguration(
            AuthenticationManager authenticationManager,
            UserDetailService userDetailService
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailService)
        ;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(clientApp)
                .authorizedGrantTypes("password", "refresh_token")
                .authorities(
                        Stream.of(Role.values())
                                .map(Enum::name)
                                .toArray(String[]::new)
                )
                .scopes("read", "write")
                .resourceIds(resourceId)
                .secret(clientSecret);
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);
        return tokenServices;
    }
}
