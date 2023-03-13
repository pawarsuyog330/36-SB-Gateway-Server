package com.ashokit.gateway.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
//@EnableWebFluxSecurity
public class GatewaySecurityConfig {
	/*
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(exchanges -> exchanges.pathMatchers("/c/**")
				                                     .authenticated()
				                                     .pathMatchers("/p/**")
				                                     .authenticated()
				                                     .pathMatchers("/f/**")
				                                     .permitAll())
		    .oauth2ResourceServer().jwt();
		return http.build();
	}
	*/
}
