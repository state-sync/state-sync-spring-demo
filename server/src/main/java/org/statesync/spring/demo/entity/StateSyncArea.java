package org.statesync.spring.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Collection of sync areas
 *
 * @author ify
 *
 */
@Data
@Document
public class StateSyncArea {

	/**
	 * Unique id of stay sync area
	 */
	@Id
	private String id;
}
