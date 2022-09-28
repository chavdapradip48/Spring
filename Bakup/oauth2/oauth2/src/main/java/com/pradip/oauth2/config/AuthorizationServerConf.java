package com.pradip.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.pradip.oauth2.service.CustomUserDetailService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConf extends AuthorizationServerConfigurerAdapter {
	
//	static final String CLIEN_ID = "devglan-client";
//	static final String CLIENT_SECRET = "devglan-secret";
//	static final String GRANT_TYPE = "password";
//	static final String AUTHORIZATION_CODE = "authorization_code";
//	static final String REFRESH_TOKEN = "refresh_token";
//	static final String IMPLICIT = "implicit";
//	static final String SCOPE_READ = "read";
//	static final String SCOPE_WRITE = "write";
//	static final String TRUST = "trust";
//	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
//    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;
//	
//	@Autowired
//	private TokenStore tokenStore;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//		
//		System.out.println(encode().encode("123"));
//		
//		configurer
//				.inMemory()
//				.withClient("pradip")
//				.secret(encode().encode("123"))
//				.authorizedGrantTypes("password","authorization_code" , "refresh_token", "implicit" )
//				.scopes("read", "write", "trust")
//				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
//				refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
//	}
//
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore)
//				.authenticationManager(authenticationManager);
//	}
	
	private static final String RESOURCE_ID = "myrestservice";

	TokenStore tokenStore=new InMemoryTokenStore();
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager).userDetailsService(customUserDetailService);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("pradip").authorizedGrantTypes("password","refresh_token").scopes("read","write").secret(encode().encode("123")).resourceIds(RESOURCE_ID);
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices=new DefaultTokenServices();
		tokenServices.setTokenStore(this.tokenStore);
		return tokenServices;
	}
	
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
}
