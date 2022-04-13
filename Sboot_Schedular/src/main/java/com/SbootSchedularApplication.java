package com;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SbootSchedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootSchedularApplication.class, args);
	}
	
	@Value("${schedular3Timing}")
	String schedular3Timing;
	
	@Bean
	public String getIntervalTime() 
	{
		long startSchedulerAfterMiliSec = setSchedule(schedular3Timing);

		return ""+startSchedulerAfterMiliSec;
	}
	
	public long setSchedule(String key) 
	{
		int hour = Integer.parseInt(key.substring(0, key.indexOf(":")));
		int min = Integer.parseInt(key.substring(key.indexOf(":") + 1));

		Calendar schedulerCal = Calendar.getInstance();
		schedulerCal.set(Calendar.HOUR, hour);
		schedulerCal.set(Calendar.MINUTE, min);
		schedulerCal.set(Calendar.SECOND, 0);
		
		Calendar localCal = Calendar.getInstance();
		Long currentTimeInMilliSec = localCal.getTime().getTime();
		String currentDayTime = localCal.getTime().toString();

		if (schedulerCal.getTime().getTime() < currentTimeInMilliSec) {			// matlab ki 00:00 time se se milisec calculate karke, agar current time 1000 mili-sec hai, aur scheduled time 800 mili-sec hua, malab ki wo already bit chuka hai, add a day more 
			schedulerCal.add(Calendar.DATE, 1);			// add 1 day more in the Schedular, if scheduled-MiliSec agar current-MiliSec se kam hai to.
		}

		long scheduledTimeInMilliSec = schedulerCal.getTime().getTime();
		String scheduledTime = schedulerCal.getTime().toString();
		System.out.println("** Scheduled start time for the task	: " + scheduledTime + " *** " + scheduledTimeInMilliSec);
		System.out.println("** Current time of the day		: " + currentDayTime + " *** " + currentTimeInMilliSec);

		long startScheduler = scheduledTimeInMilliSec - currentTimeInMilliSec;		// eg: scheduledTime(5pm) - currentTime(3pm) = (2hr)startSchedulerAfter
		return startScheduler;

	}

}
