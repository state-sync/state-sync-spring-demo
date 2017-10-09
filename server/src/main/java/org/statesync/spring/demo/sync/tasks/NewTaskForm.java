package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.BootstrapStatus;

import lombok.Data;

@Data
public class NewTaskForm {
	public String summary = "";
	public String message = "";
	public BootstrapStatus status = BootstrapStatus.success;

	public void success() {
		this.summary = "";
		this.status = BootstrapStatus.success;
		this.message = "Task created";
	}

	public boolean validate() {
		return true;
	}
}
