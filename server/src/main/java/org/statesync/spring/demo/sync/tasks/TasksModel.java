package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.AnnotatedList;
import org.statesync.model.ListQuery;

import lombok.Data;

@Data
public class TasksModel {
	public String filter;
	public ListQuery query = new ListQuery();
	public AnnotatedList<TaskRow> items = new AnnotatedList<>();
}
