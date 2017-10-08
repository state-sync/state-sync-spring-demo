package org.statesync.spring.demo.service;

import java.time.LocalTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import org.statesync.model.ListQuery;
import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.entity.TaskStatus;
import org.statesync.spring.demo.service.repository.TaskRepository;

@Service
public class TaskService extends BaseService<String, Task, TaskRepository> {

	private int fakeCounter = 0;

	@Autowired
	protected TaskService(final TaskRepository repository) {
		super(repository);
	}

	public Page<Task> find(final ListQuery query) {
		final Pageable pageable = JPAHelper.toPageable(query);
		if (StringUtils.isBlank(query.search)) {
			return repository().findBy(pageable);
		} else {
			final TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(query.searchKeywords());
			return repository().findBy(criteria, pageable);
		}
	}

	public void newTask() {
		final Task task = new Task();
		task.status = TaskStatus.New;
		task.summary = "#" + (this.fakeCounter++) + " Some task at " + LocalTime.now();
		this.repository().save(task);
	}

}
