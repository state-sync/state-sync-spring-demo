package org.statesync.spring.demo.sync.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.statesync.SyncAreaUser;
import org.statesync.spring.SpringSyncArea;
import org.statesync.spring.SyncAreaService;

import com.google.common.primitives.Doubles;

@SyncAreaService(id = "dashboard", model = DashboardModel.class, clientPush = { "/settings" })
public class DashboardArea extends SpringSyncArea<DashboardModel> {

	private void fillChart(final DashboardModel model) {
		final List<Double> data = new ArrayList<>(Doubles.asList(model.chart1.data.datasets.get(0).data));

		data.remove(0);
		model.chart1.data.datasets.get(0).backgroundColor = "#FF0";
		data.add((double) new Random(System.currentTimeMillis()).nextInt(100));
		model.chart1.data.datasets.get(0).data = Doubles.toArray(data);
	}

	@Override
	protected DashboardModel process(final DashboardModel model, final SyncAreaUser<DashboardModel> user) {
		model.name = "My dashboard";
		fillChart(model);
		return model;
	}

	@Scheduled(fixedRate = 5000)
	public void updateByTimer() {
		try {
			this.getArea().syncAll((model, user) -> {
				if (model.settings.watch) {
					fillChart(model);
				}
				return model;
			});
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
