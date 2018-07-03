// Generated by delombok at Tue Jul 03 21:12:42 NOVT 2018
package org.statesync.spring.demo.sync.tasks;

import org.statesync.model.BootstrapStatus;

public class NewTaskForm {
	public String summary = "";
	public String message = "";
	public BootstrapStatus status = BootstrapStatus.success;

	public void success() {
		this.summary = "";
		this.status = BootstrapStatus.success;
		this.message = "Task created";
	}

	public boolean validate() {
		return true;
	}

	@java.lang.SuppressWarnings("all")
	public NewTaskForm() {
	}

	@java.lang.SuppressWarnings("all")
	public String getSummary() {
		return this.summary;
	}

	@java.lang.SuppressWarnings("all")
	public String getMessage() {
		return this.message;
	}

	@java.lang.SuppressWarnings("all")
	public BootstrapStatus getStatus() {
		return this.status;
	}

	@java.lang.SuppressWarnings("all")
	public void setSummary(final String summary) {
		this.summary = summary;
	}

	@java.lang.SuppressWarnings("all")
	public void setMessage(final String message) {
		this.message = message;
	}

	@java.lang.SuppressWarnings("all")
	public void setStatus(final BootstrapStatus status) {
		this.status = status;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this) return true;
		if (!(o instanceof NewTaskForm)) return false;
		final NewTaskForm other = (NewTaskForm) o;
		if (!other.canEqual((java.lang.Object) this)) return false;
		final java.lang.Object this$summary = this.getSummary();
		final java.lang.Object other$summary = other.getSummary();
		if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary)) return false;
		final java.lang.Object this$message = this.getMessage();
		final java.lang.Object other$message = other.getMessage();
		if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
		final java.lang.Object this$status = this.getStatus();
		final java.lang.Object other$status = other.getStatus();
		if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
		return true;
	}

	@java.lang.SuppressWarnings("all")
	protected boolean canEqual(final java.lang.Object other) {
		return other instanceof NewTaskForm;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final java.lang.Object $summary = this.getSummary();
		result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
		final java.lang.Object $message = this.getMessage();
		result = result * PRIME + ($message == null ? 43 : $message.hashCode());
		final java.lang.Object $status = this.getStatus();
		result = result * PRIME + ($status == null ? 43 : $status.hashCode());
		return result;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "NewTaskForm(summary=" + this.getSummary() + ", message=" + this.getMessage() + ", status=" + this.getStatus() + ")";
	}
}
