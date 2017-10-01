package org.statesync.spring.demo.util;

import static java.util.Collections.singletonList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.statesync.spring.demo.entity.Role;
import org.statesync.spring.demo.entity.UserProfile;
import org.statesync.spring.demo.service.UserProfileService;

@Component
@Profile({ "prod", "dev", "default" })
public class Listeners {

	@Value("${auth.admin.email}")
	protected String adminEmail;

	@Value("${auth.admin.password}")
	protected String adminPassword;

	@Value("${auth.demo.email}")
	protected String demoEmail;

	@Value("${auth.demo.password}")
	protected String demoPassword;

	private final UserProfileService UserProfileService;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public Listeners(final UserProfileService UserProfileService, final PasswordEncoder passwordEncoder) {
		this.UserProfileService = UserProfileService;
		this.passwordEncoder = passwordEncoder;
	}

	private void checkUsers() {
		if (this.UserProfileService.findByEmail(this.adminEmail) == null) {
			final UserProfile profile = new UserProfile();
			profile.setFullName("administrator");
			profile.setEmail(this.adminEmail);
			profile.setRoles(singletonList(Role.ROLE_ADMIN));
			profile.setPassword(this.passwordEncoder.encode(this.adminPassword));
			this.UserProfileService.save(profile);
		}

		if (this.UserProfileService.findByEmail(this.demoEmail) == null) {
			final UserProfile profile = new UserProfile();
			profile.setFullName("demo profile");
			profile.setEmail(this.demoEmail);
			profile.setRoles(singletonList(Role.ROLE_USER));
			profile.setPassword(this.passwordEncoder.encode(this.demoPassword));
			this.UserProfileService.save(profile);
		}
	}

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEventListener(final ContextRefreshedEvent event) {
		checkUsers();
	}
}
