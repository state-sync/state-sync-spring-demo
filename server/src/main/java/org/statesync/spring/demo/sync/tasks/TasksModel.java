package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.AnnotatedList;

import lombok.Data;

@Data
public class TasksModel {
	public String filter;
	public TasksQuery query = new TasksQuery();
	public AnnotatedList<TaskRow> items = new AnnotatedList<>();
}
