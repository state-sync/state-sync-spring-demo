package org.statesync.spring.demo.sync.table;

import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaUser;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;

@SyncAreaService(id = "table", model = TableModel.class, clientPush = { "/settings" })
public class TableArea extends SpringSyncArea<TableModel> {

	@Override
	protected TableModel process(final TableModel model, final SyncAreaUser<TableModel> user) {
		return model;
	}

	@Scheduled(fixedRate = 5000)
	public void updateByTimer() {
		try {
			this.getArea().syncAll();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
