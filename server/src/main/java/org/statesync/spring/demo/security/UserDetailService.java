// Generated by delombok at Tue Jul 03 21:12:42 NOVT 2018
package org.statesync.spring.demo.security;

import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.statesync.spring.demo.entity.UserProfile;
import org.statesync.spring.demo.service.repository.UserProfileRepository;

@Service
public class UserDetailService implements UserDetailsService {
	@java.lang.SuppressWarnings("all")
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(UserDetailService.class.getName());
	private final UserProfileRepository userProfileRepository;

	@Autowired
	public UserDetailService(final UserProfileRepository personalProfileRepository) {
		this.userProfileRepository = personalProfileRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String email) {
		final UserProfile profile = this.userProfileRepository.findByEmail(email);
		if (profile == null) {
			log.log(Level.WARNING, "loadUserByUsername: profile not found by email {}", email);
			throw new UsernameNotFoundException("profile not found");
		}
		return new UserBean(profile);
	}
}
