package org.statesync.spring.demo.sync.debug;

import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaApi;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;

@SyncAreaService(id = "debug", model = StateSyncInfoModel.class, clientPush = {})
public class DebugArea extends SpringSyncArea<StateSyncInfoModel> {

	@Override
	protected StateSyncInfoModel process(final StateSyncInfoModel model, final SyncAreaApi<StateSyncInfoModel> user) {
		model.info = null;//this.service.getInfo();
		return model;
	}

	@Scheduled(fixedRate = 1000)
	public void updateByTimer() {
	//
	}
}
