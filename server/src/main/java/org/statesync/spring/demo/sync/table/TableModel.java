package org.statesync.spring.demo.sync.table;

import org.statesync.model.AnnotatedList;

import lombok.Data;

@Data
public class TableModel {
	public String filter;
	public ItemListQuery query = new ItemListQuery();
	public AnnotatedList<TableItem> items = new AnnotatedList<>();
}
