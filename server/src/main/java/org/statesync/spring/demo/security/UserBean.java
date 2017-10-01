package org.statesync.spring.demo.security;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.statesync.spring.demo.entity.UserProfile;

public class UserBean implements UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = -5364508637798150477L;

	private UserProfile profile;

	public UserBean(final UserProfile profile) {
		this.profile = profile;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profile.getRoles().stream().map(Enum::name).map(SimpleGrantedAuthority::new).collect(toList());
	}

	@Override
	public String getPassword() {
		return this.profile.getPassword();
	}

	public UserProfile getProfile() {
		return this.profile;
	}

	@Override
	public String getUsername() {
		return this.profile.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
