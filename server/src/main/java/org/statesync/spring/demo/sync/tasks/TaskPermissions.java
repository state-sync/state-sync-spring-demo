package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.permissions.ItemCrudPermissions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskPermissions extends ItemCrudPermissions {
	public static final TaskPermissions ALL = new TaskPermissions();
	public static final TaskPermissions READONLY = new TaskPermissions();
	public static final TaskPermissions EDIT = new TaskPermissions();
	static {
		ALL.delete = true;
		ALL.edit = true;
		EDIT.delete = false;
		EDIT.edit = true;
		READONLY.delete = false;
		READONLY.edit = false;
	}
}
