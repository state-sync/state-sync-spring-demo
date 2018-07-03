package org.statesync.spring.demo.sync.tasks;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaApi;
import org.statesync.model.AnnotatedItem;
import org.statesync.model.AnnotatedList;
import org.statesync.model.ItemRequest;
import org.statesync.model.Pagination;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;
import org.statesync.spring.SyncSignal;
import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.entity.TaskStatus;
import org.statesync.spring.demo.service.TaskService;

@SyncAreaService(id = "tasks", model = TasksModel.class, clientPush = { "/query", "/newTask", "/editTask" })
public class TasksSyncArea extends SpringSyncArea<TasksModel> {

	private TaskService taskService;

	private int generated = 0;

	@Autowired
	public TasksSyncArea(final TaskService taskService) {
		this.taskService = taskService;
	}

	@SyncSignal(name = "createTask")
	public TasksModel createTask(final TasksModel model, final SyncAreaApi<TasksModel> user) {
		// if (model.newTask.validate()) {
		this.taskService.newTask(model.newTask.summary);
		model.newTask.success();
		return model;
	}

	@SyncSignal(name = "editTask")
	public TasksModel editTask(final TasksModel model, final SyncAreaApi<TasksModel> user, final ItemRequest taskId) {
		final Set<String> permissions = new HashSet<>();
		final Task task = this.taskService.findOne(taskId.id);
		if (task.status != TaskStatus.Closed)
			permissions.add("edit");
		model.editTask = new AnnotatedItem<>(new EditTaskForm(task), this.taskService.getPermissions(task));
		return model;
	}

	@Override
	protected TasksModel process(final TasksModel model, final SyncAreaApi<TasksModel> user) {
		model.query.validate("summary");
		final Page<Task> page = this.taskService.find(model.query);
		model.items = new AnnotatedList<>();
		model.items.setData(page.getContent(), rec -> new TaskRow(rec), (rec) -> this.taskService.getPermissions(rec));
		model.items.permissions = new TaskListPermissions();
		model.items.pagination = new Pagination(page.getNumber(), page.getTotalPages(), page.getTotalElements(), 10);
		return model;
	}

	@SyncSignal(name = "saveTask")
	public TasksModel saveTask(final TasksModel model, final SyncAreaApi<TasksModel> user) {
		final Task task = model.editTask.data.toTask();
		this.taskService.save(task);
		model.editTask = null;
		return model;
	}

	@Scheduled(fixedRate = 5000)
	public void updateByTimer() {
		try {
			if (this.generated < 400) {
				this.generated++;
				this.taskService.newTask();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
