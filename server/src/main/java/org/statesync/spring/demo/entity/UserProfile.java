package org.statesync.spring.demo.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Collection of sync areas
 *
 * @author ify
 *
 */
@Document
@Data
public class UserProfile {

	/**
	 * Unique id of stay sync area
	 */
	@Id
	public String id;
	@NotNull
	public String email;
	@NotNull
	public String password;
	@NotNull
	public String fullName;
	@NotNull
	private List<Role> roles;
}
