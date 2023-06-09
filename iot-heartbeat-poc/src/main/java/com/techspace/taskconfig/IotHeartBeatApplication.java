package com.techspace.taskconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IotHeartBeatApplication {

	public static void main(String[] args) {

		SpringApplication.run(new Object[] { IotHeartBeatApplication.class }, args);
	}
}