package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.permissions.ListCrudPermissions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskListPermissions extends ListCrudPermissions {
	public boolean batchDelete;

	public TaskListPermissions() {
		this.create = true;
		this.delete = true;
	}
}
