package org.statesync.spring.demo.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.statesync.model.ListQuery;

public class JPAHelper {

	private static Sort.Direction toDirection(final String direction) {
		return Sort.Direction.fromString(direction);
	}

	public static Pageable toPageable(final ListQuery query) {
		return new PageRequest(query.page, query.pageSize, toSort(query));
	}

	public static Sort toSort(final ListQuery query) {
		return new Sort(toDirection(query.sortDirection), query.sortBy);
	}
}
