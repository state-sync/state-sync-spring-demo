package org.statesync.spring.demo.service;

import java.time.LocalTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.entity.TaskStatus;
import org.statesync.spring.demo.service.repository.TaskRepository;
import org.statesync.spring.demo.sync.tasks.TasksQuery;

@Service
public class TaskService extends BaseService<String, Task, TaskRepository> {

	@Autowired
	protected TaskService(final TaskRepository repository) {
		super(repository);
	}

	public Page<Task> find(final TasksQuery query) {
		if (StringUtils.isBlank(query.search)) {
			return repository().findBy(query.toPageable());
		} else {
			final TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(query.searchKeywords());
			return repository().findBy(criteria, query.toPageable());
		}
	}

	public void newTask() {
		final Task task = new Task();
		task.status = TaskStatus.New;
		task.summary = "Some task at " + LocalTime.now();
		this.repository().save(task);
	}

}
