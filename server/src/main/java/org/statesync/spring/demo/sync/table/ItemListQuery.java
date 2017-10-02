package org.statesync.spring.demo.sync.table;

import lombok.Data;

@Data
public class ItemListQuery {
	public String text;
	public String search;
	public String sortBy;
	public String sortOrder;
}
