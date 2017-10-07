package org.statesync.spring.demo.sync.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaUser;
import org.statesync.model.AnnotatedList;
import org.statesync.model.Pagination;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;
import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.service.TaskService;

@SyncAreaService(id = "tasks", model = TasksModel.class, clientPush = { "/query" })
public class TasksSyncArea extends SpringSyncArea<TasksModel> {

	private TaskService taskService;

	@Autowired
	public TasksSyncArea(final TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	protected TasksModel process(final TasksModel model, final SyncAreaUser<TasksModel> user) {
		model.query.validate();

		final Page<Task> page = this.taskService.find(model.query);
		model.items = new AnnotatedList<>();
		model.items.setData(page.getContent(), rec -> new TaskRow(rec));
		model.items.pagination = new Pagination(page.getNumber(), page.getTotalPages(), page.getTotalElements());
		return model;
	}

	@Scheduled(fixedRate = 5000)
	public void updateByTimer() {
		try {
			this.taskService.newTask();
			this.getArea().syncAll();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
