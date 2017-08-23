package com.bmt.cron.main;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.bmt.cron.util.BmtAccountTaskJob;
import com.bmt.cron.util.GetProperties;

public class MainBmtNeracaHarian {
	
	private static Logger log = Logger.getLogger(MainBmtNeracaHarian.class);
	
	public static void main (String []args)
	{
		GetProperties getProp = new GetProperties();
		
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sched = sf.getScheduler();
			JobDetail job = new JobDetail("BmtAccountTaskJob Neraca Harian", BmtAccountTaskJob.class);
			CronTrigger trigger = new CronTrigger("cronNeraca", "BTM", getProp.getCrontabSchedue());
			Date ft = null;
			ft = sched.scheduleJob(job,trigger);
			
			
			log.info(String.valueOf(job.getFullName()) + " has been scheduled to run at: " + ft + " and repeat based on expression: " + trigger.getCronExpression());
			sched.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
