package org.statesync.spring.demo.sync.debug;

import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaUser;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;

@SyncAreaService(id = "debug", model = StateSyncInfoModel.class, clientPush = {})
public class DebugArea extends SpringSyncArea<StateSyncInfoModel> {

	@Override
	protected StateSyncInfoModel process(final StateSyncInfoModel model, final SyncAreaUser user) {
		model.info = this.service.getInfo();
		return model;
	}

	@Scheduled(fixedRate = 1000)
	public void updateByTimer() {
		try {
			this.getArea().sync((model, user) -> {
				model.info = this.service.getInfo();
				return true;
			});
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
