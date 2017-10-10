package org.statesync.spring.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Collection of sync areas
 *
 * @author ify
 *
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	/**
	 * Unique id of stay sync area
	 */
	@Id
	public String id;

	@TextIndexed
	public String summary;

	public TaskStatus status;
}
