//package com.example.demo;
//
//import java.util.Arrays;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.context.request.RequestContextListener;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
///**
// * @author ActifyDataLabs
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfigDelete extends WebSecurityConfigurerAdapter {
//
//	@Resource(name = "userService")
//	private UserDetailsService userDetailsService;
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Autowired
//	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService);
//		return authenticationProvider;
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/auth/login");
//		web.ignoring().antMatchers("/storage/file/downloadFile/**");
//		web.ignoring().antMatchers("/resultservice/file/downloadFile/**");
//		web.ignoring().antMatchers("/voxco/chart/generateiFrameChart/**");
//		web.ignoring().antMatchers("/report/download/**");
//		web.ignoring().antMatchers("/dashboards/publish/**");
//		web.ignoring().antMatchers("/dashboards/publish/logo");
//		web.ignoring().antMatchers("/dashboards/url/shorten");
//		web.ignoring().antMatchers("/dashboards/s/**");
//		web.ignoring().antMatchers("/workflows/node/starbucks/**");
//		web.ignoring().antMatchers("/voxco/password/getMd5");
//		web.ignoring().antMatchers("/workflowservice/uploadFile");
//
//		web.ignoring().antMatchers(HttpMethod.OPTIONS);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/**").permitAll()
//				.antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
//				.antMatchers(HttpMethod.POST, "/auth/login").permitAll()
//				.antMatchers(HttpMethod.GET, "/storage/file/downloadFile/**").permitAll()
//				.antMatchers(HttpMethod.GET, "/report/download/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/dashboards/publish").permitAll()
//				.antMatchers(HttpMethod.GET, "/voxco/chart/generateiFrameChart/**").permitAll()
//				.antMatchers(HttpMethod.GET, "/dashboards/publish/**").permitAll()
//				.antMatchers(HttpMethod.GET, "/workflows/node/starbucks/**").permitAll()
//				.antMatchers(HttpMethod.GET, "/dashboards/publish/logo").permitAll()
//				.antMatchers(HttpMethod.POST, "/voxco/password/getMd5").permitAll()
//				.antMatchers(HttpMethod.GET, "/resultservice/file/downloadFile/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/dashboards/url/shorten").permitAll()
//				.antMatchers(HttpMethod.GET, "/dashboards/s/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/workflowservice/uploadFile").permitAll();
//
//	}
//
//	@Bean
//	public FilterRegistrationBean corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new org.springframework.web.filter.CorsFilter(source));
//		bean.setOrder(0);
//		return bean;
//	}
//
//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList("*"));
//		configuration.setAllowedHeaders(Arrays.asList("*"));
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//
//	@Bean
//	public RequestContextListener requestContextListener() {
//		return new RequestContextListener();
//	}
//}
