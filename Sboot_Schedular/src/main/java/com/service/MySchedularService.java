package com.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MySchedularService {

	private static final Logger logger = LoggerFactory.getLogger(MySchedularService.class);

//	@Scheduled(fixedRate = 2000, initialDelay = 5000L)
	@Scheduled(fixedRateString = "${schedular1.fixedRateInMS}", initialDelay = 1000L)
	public void job() {
		logger.info("Job1 Run Time : " + new Date());
	}
	
//	@Scheduled(fixedRateString = "${schedular2.fixedRateInMS}", initialDelay = 5000L)
//	public void job2() {
//		logger.info("Job2 Run Time : " + new Date());
//	}

	@Scheduled(fixedRate = 10000 , initialDelayString = "#{@getIntervalTime}")		// we can change the fixedRate = 86400000L miliseconds (i.e, one day interval)    
	public void job3() {
		logger.info("**Job2 Run Time : " + new Date());
	}
	
	

}
