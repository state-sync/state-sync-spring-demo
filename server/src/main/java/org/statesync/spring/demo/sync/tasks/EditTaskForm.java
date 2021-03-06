// Generated by delombok at Tue Jul 03 21:12:42 NOVT 2018
package org.statesync.spring.demo.sync.tasks;

import org.statesync.spring.demo.entity.Task;
import org.statesync.spring.demo.entity.TaskStatus;

public class EditTaskForm {
	public String id;
	public String $id;
	public String summary;
	public TaskStatus status;

	public EditTaskForm(final Task src) {
		this.$id = this.id = src.id;
		this.summary = src.summary;
		this.status = src.status;
	}

	public Task toTask() {
		return new Task(this.$id, this.summary, this.status);
	}

	public boolean validate() {
		return true;
	}

	@java.lang.SuppressWarnings("all")
	public String getId() {
		return this.id;
	}

	@java.lang.SuppressWarnings("all")
	public String getSummary() {
		return this.summary;
	}

	@java.lang.SuppressWarnings("all")
	public TaskStatus getStatus() {
		return this.status;
	}

	@java.lang.SuppressWarnings("all")
	public void setId(final String id) {
		this.id = id;
	}

	@java.lang.SuppressWarnings("all")
	public void setSummary(final String summary) {
		this.summary = summary;
	}

	@java.lang.SuppressWarnings("all")
	public void setStatus(final TaskStatus status) {
		this.status = status;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this) return true;
		if (!(o instanceof EditTaskForm)) return false;
		final EditTaskForm other = (EditTaskForm) o;
		if (!other.canEqual((java.lang.Object) this)) return false;
		final java.lang.Object this$id = this.getId();
		final java.lang.Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final java.lang.Object this$summary = this.getSummary();
		final java.lang.Object other$summary = other.getSummary();
		if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary)) return false;
		final java.lang.Object this$status = this.getStatus();
		final java.lang.Object other$status = other.getStatus();
		if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
		return true;
	}

	@java.lang.SuppressWarnings("all")
	protected boolean canEqual(final java.lang.Object other) {
		return other instanceof EditTaskForm;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final java.lang.Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final java.lang.Object $summary = this.getSummary();
		result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
		final java.lang.Object $status = this.getStatus();
		result = result * PRIME + ($status == null ? 43 : $status.hashCode());
		return result;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "EditTaskForm(id=" + this.getId() + ", summary=" + this.getSummary() + ", status=" + this.getStatus() + ")";
	}

	@java.lang.SuppressWarnings("all")
	public EditTaskForm() {
	}
}
