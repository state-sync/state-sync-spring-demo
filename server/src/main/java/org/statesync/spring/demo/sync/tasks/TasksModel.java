package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.AnnotatedItem;
import org.statesync.model.AnnotatedList;
import org.statesync.model.ListQuery;

import lombok.Data;

@Data
public class TasksModel {
	public ListQuery query = new ListQuery();
	public NewTaskForm newTask = new NewTaskForm();
	public AnnotatedItem<EditTaskForm, TaskPermissions> editTask;
	public AnnotatedList<TaskRow, TaskPermissions, TaskListPermissions> items = new AnnotatedList<>();
}
