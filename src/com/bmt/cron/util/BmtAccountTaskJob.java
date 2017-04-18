package com.bmt.cron.util;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bmt.cron.controller.Accounting;

public class BmtAccountTaskJob implements Job {

	private static Logger log=Logger.getLogger(BmtAccountTaskJob.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		run();
	}
	
	public void run()
	{
		Accounting.getNeracaHarian();
	}

}
