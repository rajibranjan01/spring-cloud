package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author ActifyDataLabs
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.anonymous().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll() // .anyRequest().permitAll()
//				.antMatchers("/**").permitAll().antMatchers("/admin/**").hasAnyAuthority("ADMIN", "POWER_USER")
//				.antMatchers("/storage/**", "/centrum/**", "/workflowservice/**", "/dashboards/**", "/report/**",
//						"/components/**", "/registry/**", "/voxco/**", "/querytool/**", "/resultservice/**",
//						"/modelregistryservice/**", "/smartsenseservices/**", "/compilerservice/**",
//						"/queryeditorservice/**")
//				.hasAnyAuthority("DEVELOPER", "DATA_ANALYST").and().exceptionHandling().accessDeniedPage("/auth/deny");

		http.anonymous().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll() // .anyRequest().permitAll()
				.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

	}

}