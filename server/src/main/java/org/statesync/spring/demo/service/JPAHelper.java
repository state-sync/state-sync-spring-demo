package org.statesync.spring.demo.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.statesync.model.ListQuery;

public class JPAHelper {

	public static Pageable toPageable(final ListQuery query) {
		return new PageRequest(query.page, query.pageSize, toSort(query));
	}

	public static Sort toSort(final ListQuery query) {
		return new Sort(query.sortDirection, query.sortBy);
	}
}
