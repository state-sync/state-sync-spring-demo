package org.statesync.spring.demo.security;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.statesync.spring.demo.entity.UserProfile;
import org.statesync.spring.demo.service.repository.UserProfileRepository;

import lombok.extern.java.Log;

@Service
@Log
public class UserDetailService implements UserDetailsService {

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
