package org.statesync.spring.demo.sync.dashboard;

import lombok.Data;

@Data
public class DashboardModel {
	public final DashboardSettings settings = new DashboardSettings();
	public String name;
	public LinearChart chart1 = new LinearChart();
}
