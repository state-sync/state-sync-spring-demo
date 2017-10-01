package org.statesync.spring.demo.security;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebSecurity
@EnableSpringDataWebSupport
public class SecurityConfig extends WebMvcConfigurationSupport {

	private final UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfig(final UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
		final PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		argumentResolvers.add(resolver);
		argumentResolvers.add(new AuthenticatedUserHandlerMethodArgumentResolver());
		super.addArgumentResolvers(argumentResolvers);
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		final DaoAuthenticationProvider p = new DaoAuthenticationProvider();
		p.setUserDetailsService(this.userDetailsService);
		p.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(Collections.singletonList(p));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
