package com.koreait.integration.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class StaffJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("StaffJob 동작 완료!");

	}

}

