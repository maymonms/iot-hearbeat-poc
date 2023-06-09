package com.techspace.taskconfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.techspace.rest.ApiClient;
import com.techspace.utils.ConfigurationProperties;

import okhttp3.Response;

@Component
public class ScheduledTasks {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");
	
	@Autowired
	private Environment env;

/*	
	@Scheduled(fixedRate = 10000)
	public void performTask() {

		System.out.println("Regular task performed at "
				+ dateFormat.format(new Date()));

	}

	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void performDelayedTask() {

		System.out.println("Delayed Regular task performed at "
				+ dateFormat.format(new Date()));

	}
*/
	
	/**
	 * Task with interval of 5 seconds
	 */
	@Scheduled(cron = "*/5 * * * * *")
	public void performTaskUsingCron() {

		try {
			logger.info("Heart beat sent as a rest API at "+ dateFormat.format(new Date()));
			ApiClient api = new ApiClient();
			String endpoint = env.getProperty("api_to_test");
			Response response = api.get(endpoint);
			logger.info(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
