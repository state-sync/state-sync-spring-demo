package org.statesync.spring.demo.sync;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.statesync.spring.AbstractStateSyncConfig;

@Configuration
@EnableWebSocketMessageBroker
public class WSConfig extends AbstractStateSyncConfig {

}
