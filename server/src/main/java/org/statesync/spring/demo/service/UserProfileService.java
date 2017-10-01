package org.statesync.spring.demo.service;

import static java.util.Collections.singletonList;
import static org.statesync.spring.demo.util.Preconditions.checkFalse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.statesync.spring.demo.entity.Role;
import org.statesync.spring.demo.entity.UserProfile;
import org.statesync.spring.demo.service.repository.UserProfileRepository;

@Service
public class UserProfileService extends BaseService<String, UserProfile, UserProfileRepository> {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserProfileService(final UserProfileRepository personalProfileRepository, final PasswordEncoder passwordEncoder) {
		super(personalProfileRepository);
		this.passwordEncoder = passwordEncoder;
	}

	public UserProfile findByEmail(final String email) {
		return repository().findByEmail(email);
	}

	public UserProfile register(final String email, final String password) {

		checkFalse(repository().existsByEmail(email), "email.exists", HttpStatus.CONFLICT);

		final UserProfile user = new UserProfile();

		user.setEmail(email);
		user.setRoles(singletonList(Role.ROLE_USER));
		user.setPassword(this.passwordEncoder.encode(password));

		return repository().save(user);
	}
}
