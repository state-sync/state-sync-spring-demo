package org.statesync.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.statesync.spring.SpringSyncService;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackageClasses = { DemoApplication.class, SpringSyncService.class })
public class DemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
