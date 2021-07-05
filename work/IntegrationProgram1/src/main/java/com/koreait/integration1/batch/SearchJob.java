package com.koreait.integration1.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SearchJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("SearchJob 동작 완료!");

	}

}

