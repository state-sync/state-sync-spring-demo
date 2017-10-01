package org.statesync.spring.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * Collection of sync areas
 *
 * @author ify
 *
 */
@Data
public class StateSyncArea {

	/**
	 * Unique id of stay sync area
	 */
	@Id
	private String id;
}
