package org.statesync.spring.demo.sync.tasks;

import org.statesync.spring.demo.entity.Task;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskRow {
	public String id;
	public String summary;
	public String status;

	public TaskRow(final Task rec) {
		this.id = rec.id;
		this.summary = rec.summary;
		this.status = rec.status.name();
	}
}
