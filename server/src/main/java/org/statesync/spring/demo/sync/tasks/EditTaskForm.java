package org.statesync.spring.demo.sync.tasks;

import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.entity.TaskStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditTaskForm {
	public String id;
	public String $id;

	public String summary;

	public TaskStatus status;

	public EditTaskForm(final Task src) {
		this.$id = this.id = src.id;
		this.summary = src.summary;
		this.status = src.status;
	}

	public Task toTask() {
		return new Task(this.$id, this.summary, this.status);
	}

	public boolean validate() {
		return true;
	}
}
