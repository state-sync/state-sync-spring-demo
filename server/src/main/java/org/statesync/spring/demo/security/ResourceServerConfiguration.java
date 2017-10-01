package org.statesync.spring.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Value("${security.oauth2.securedUrl}")
	private String securedUrl;

	@Value("${api.base-path}")
	private String apiBasePath;

	@Value("${security.oauth2.resource.id}")
	private String resourceId;

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(this.apiBasePath + "/account/register").anonymous().and()
				.authorizeRequests().antMatchers(this.securedUrl).authenticated();
	}

	@Override
	public void configure(final ResourceServerSecurityConfigurer resources) {
		resources.resourceId(this.resourceId);
	}
}
