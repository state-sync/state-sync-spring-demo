package org.statesync.spring.demo.sync.tasks;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class TasksQuery {
	public String search;
	public String sortBy;
	public String sortOrder;
	public int page;
	public int pageSize = 5;

	public String[] searchKeywords() {
		return this.search == null ? new String[0] : this.search.split("\\s");
	}

	public Pageable toPageable() {
		return new PageRequest(this.page, this.pageSize);
	}

	public void validate() {
		if (this.pageSize < 5)
			this.pageSize = 5;
		if (this.page < 0)
			this.page = 0;
	}
}
