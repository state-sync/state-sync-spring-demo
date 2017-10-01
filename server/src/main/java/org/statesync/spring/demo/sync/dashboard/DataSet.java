package org.statesync.spring.demo.sync.dashboard;

import lombok.Data;

@Data
public class DataSet {
	public String label = "My First dataset";
	public String backgroundColor = "#FF8";
	public String borderColor = "rgba(255,255,255,.55)";
	public double[] data = new double[] { 65.0, 59, 84, 84, 51, 55, 40.0 };
}
