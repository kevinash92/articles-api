package com.mebcorp.articleApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.mebcorp.articleApp.security.AccountDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	private static String REALM="AUTH_REALM";
//	private static final int ONE_DAY = 60 * 60 * 24;
	private static final int ONE_MIN = 60;
	private static final int THIRTY_DAYS = 60 * 60 * 24 * 30;
	
	@Autowired
	private TokenStore tokenStore;
	@Autowired
	private UserApprovalHandler userApprovalHandler;
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	@Autowired
	private AccountDetailsService accountDetailsService;
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//	    clients.inMemory()
//	    .withClient("crmClient1")
//            .secret(new BCryptPasswordEncoder().encode("crmSuperSecret"))
//            .authorizedGrantTypes("password", "refresh_token")
//            .authorities("ROLE_ADMIN", "ROLE_TRUSTED_CLIENT")
//            .scopes("read", "write", "trust")
//            //.accessTokenValiditySeconds(ONE_DAY)
//            .accessTokenValiditySeconds(5*ONE_MIN)
//            .refreshTokenValiditySeconds(THIRTY_DAYS);
		
//		clients.withClientDetails(new ClientDetailsService() {
//			
//			@Override
//			public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
//				BaseClientDetails client = new BaseClientDetails();
//				client.setClientId("crmClient1");
//				client.setClientSecret(new BCryptPasswordEncoder().encode("crmSuperSecret"));
//				client.setAuthorizedGrantTypes(Lists.newArrayList("password", "refresh_token"));
//				client.setScope(Lists.newArrayList("read", "write", "trust"));
//				client.setAccessTokenValiditySeconds(300);
//				client.setRefreshTokenValiditySeconds(THIRTY_DAYS);
//				return client;
//			}
//		});
		
		clients.jdbc(dataSource);
		
	}
 
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
		.userApprovalHandler(userApprovalHandler)
		.authenticationManager(authenticationManager)
		.userDetailsService(accountDetailsService);
	}
 
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(new BCryptPasswordEncoder());
		oauthServer.realm(REALM);
	}
	
	
}
