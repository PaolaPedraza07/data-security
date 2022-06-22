package com.training.epam.springboot.datasecurity.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class ConfigOAuth2 extends AuthorizationServerConfigurerAdapter {
    private String clientId = "pixeltrice";
    private String clientSecret = "pixeltrice-secret-key";
    private String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCvf5iZcqohRZfP\n" +
            "gww/J6xm2YICEMxaCfls3CU970qVsaNvmjk4G69MFtiCy7vy9utMD0qlxSwB9Ccu\n" +
            "9SttS9A0vknnY1MkjcRH1n4QrDtKeIH9ooeTB8rs2eGskXdKx7KFFVXjHKCf/caz\n" +
            "IgMruwWb5CLK4E/KTTdCoLXgnVHOdcoU4UDJZhkol+Z81mb2Iqm6k6mpl1IH3BE7\n" +
            "zwv6F/IjmHqNpsOOS6A1qd4xCNZ2CFkVo8MV0XT0U7NDssu1xbZEZYxGed2U6RUM\n" +
            "JE3nESdfjYt7cks/ppQqmLoJ95FXkP8mMEa1oBIWnh4AOVXdNFS/nNb24YVbmdhF\n" +
            "Z+gwZefvAgMBAAECggEANJ6rYIby39r/86Y1S9JXbNcWlgv3WZ/X+33eZL2UvWFv\n" +
            "wYyaT2ptmwDWlhEEH4tNbZbAKQf/c+6CuR+lj7XFjaroecpcKX+gNHHphpI9jMyp\n" +
            "HSVYRQt3GqERey56eB98NU76W4g/2Pi8VQWDsd73hZBXpkCva9bPFNke72P8HUzP\n" +
            "7NNBcMGLY5reKB2uuMKpTfzw9zeCB2uAbddAGB2TlU3RFnltzZMUcOPBLFeLEsYt\n" +
            "GzR1Z9PsFA0XbExVG5phIqWou2aqdW+RMdKTy+sT4jbvWuIXFFEKRqI4N6ZNSfEF\n" +
            "ftPt7JztlW9Esf8gwV1SDbxH0oZZr6SHriSbdedPkQKBgQC76IUE/wnV7XX5F3ZW\n" +
            "Tg+YlaoUMQxRuB93WGl4tXAxCys/kKXPrNHdujAg0qRNJt8hQANy+0rNg7IIARxq\n" +
            "ZE/shUYd8FPtoRXG9aKi9YIsE/R/j0ce3JBx2MNyiw1Lr9BC32tlBUCZg7mWL/mc\n" +
            "cXw6/jCBxYdc37JvD3dvh/wPQwKBgQDvF91qZ4sVVNiv5B0XHNbgdpGUlTl0sQKC\n" +
            "47AEnrWECOe26CBLXRmI5iVr9/UTlYxI1L75C/7Z/SmIHljD94wvxLbnCkFFmN0Y\n" +
            "B5r/xoCt8b8EB6o5C4LA8+UVjFPCsdvJ9TH+hp7CJrJ5rLX7i2BMrmXgbOn1VhFe\n" +
            "s40tWXQr5QKBgCDE8vWlGG0DRVCUQ+HXKScd6pQs3Y4ewvYIKBSR56fV38vtCM2H\n" +
            "wO2e+6ettFN0FPNye2eA5VGjxtdYgkEXj0ybDVhJQgmtzuNskNlEYVgYfsoEDY4X\n" +
            "PuVrvOHr1/y8A2C2H791RAfBjgrgAPLEY7rR+1mWPf33UOHHW7fKii2LAoGAf2VP\n" +
            "7SpOyYb0DoSVm4MaW2/SEkGQ48SNegCoAU4vmbLFBIia7I0m1fMLbYQpac39ebEi\n" +
            "MMFbgfuK7aR9161HXQyMCH9GWDcjV3J1/GNgnU56YUNUSCECAp3yKpEi8FKkse+c\n" +
            "O+qvHPRRlNOaA/Y30aP7VKGz5618g+FYEBnh9KECgYBHlVtO4zSE9tcstGJny8Vd\n" +
            "aO7V945l3uGMwsUjo/s3/DUIoFnnOt/2jCeoNS1AJVumEbWMHI1Lc3ma67vf4iwf\n" +
            "b3+W5xtn0rPqlDajwD5kErBWdzTA7QuPoH0cbOFrlEoRG0GvFfYnJCQFTsC1qEvm\n" +
            "99LhKYDVdraOk+D3659m9Q==";

    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr3+YmXKqIUWXz4MMPyes\n" +
            "ZtmCAhDMWgn5bNwlPe9KlbGjb5o5OBuvTBbYgsu78vbrTA9KpcUsAfQnLvUrbUvQ\n" +
            "NL5J52NTJI3ER9Z+EKw7SniB/aKHkwfK7NnhrJF3SseyhRVV4xygn/3GsyIDK7sF\n" +
            "m+QiyuBPyk03QqC14J1RznXKFOFAyWYZKJfmfNZm9iKpupOpqZdSB9wRO88L+hfy\n" +
            "I5h6jabDjkugNaneMQjWdghZFaPDFdF09FOzQ7LLtcW2RGWMRnndlOkVDCRN5xEn\n" +
            "X42Le3JLP6aUKpi6CfeRV5D/JjBGtaASFp4eADlV3TRUv5zW9uGFW5nYRWfoMGXn\n" +
            "7wIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setVerifierKey(privateKey);
        converter.setSigningKey(privateKey);
        return converter;
    }


    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }


}
