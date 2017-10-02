package org.statesync.spring.demo.sync.debug;

import org.statesync.info.StateSyncInfo;

import lombok.Data;

@Data
public class StateSyncInfoModel {
	public StateSyncInfo info = new StateSyncInfo();
}
