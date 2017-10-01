package org.statesync.spring.demo.sync.dashboard;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ChartData {
	public List<String> labels = Arrays.asList("January", "February", "March", "April", "May", "June", "July");

	public List<DataSet> datasets = Arrays.asList(new DataSet());
}
