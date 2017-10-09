package org.statesync.spring.demo.sync.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaUser;
import org.statesync.model.AnnotatedList;
import org.statesync.model.Pagination;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;
import org.statesync.spring.SyncSignal;
import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.service.TaskService;

@SyncAreaService(id = "tasks", model = TasksModel.class, clientPush = { "/query", "/newTask" })
public class TasksSyncArea extends SpringSyncArea<TasksModel> {

	private TaskService taskService;

	private int generated = 0;

	@Autowired
	public TasksSyncArea(final TaskService taskService) {
		this.taskService = taskService;
	}

	@SyncSignal(name = "createTask")
	public TasksModel createTask(final TasksModel model, final SyncAreaUser<TasksModel> user) {
		// if (model.newTask.validate()) {
		this.taskService.newTask(model.newTask.summary);
		model.newTask.success();
		return model;
	}

	@Override
	protected TasksModel process(final TasksModel model, final SyncAreaUser<TasksModel> user) {
		model.query.validate("summary");
		final Page<Task> page = this.taskService.find(model.query);
		model.items = new AnnotatedList<>();
		model.items.setData(page.getContent(), rec -> new TaskRow(rec));
		model.items.pagination = new Pagination(page.getNumber(), page.getTotalPages(), page.getTotalElements());
		return model;
	}

	@Scheduled(fixedRate = 5000)
	public void updateByTimer() {
		try {
			if (this.generated < 400) {
				this.generated++;
				this.taskService.newTask();
				this.getArea().syncAll();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
