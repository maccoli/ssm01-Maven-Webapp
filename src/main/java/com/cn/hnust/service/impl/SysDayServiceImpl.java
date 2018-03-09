package com.cn.hnust.service.impl;

import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.SysdayMapper;
import com.cn.hnust.pojo.Sysday;
import com.cn.hnust.service.SysDayService;

@Service("sysDayService")
public class SysDayServiceImpl extends QuartzJobBean implements SysDayService {

	private SysdayMapper sysdayMapper;

	@Override
	public void newDayInfo() {
		Sysday sysday = new Sysday();
		Calendar calendar = Calendar.getInstance();
		sysday.setDate(calendar.getTime());
		this.sysdayMapper.insertSelective(sysday);
		System.out.println("newRecord!:" + sysday.toString());
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
/*		Scheduler scheduler = (Scheduler) context.getScheduler();
		try {
			// 获取JobExecutionContext中的service对象
			SchedulerContext schCtx = context.getScheduler().getContext();
			// 获取Spring中的上下文
			ApplicationContext appCtx = (ApplicationContext) schCtx.get("applicationContext");
			sysdayMapper = (SysdayMapper) appCtx.getBean("sysdayMapper");
		} catch (SchedulerException e1) {
			// TODO 尚未处理异常
			e1.printStackTrace();
		}*/
		sysdayMapper = (SysdayMapper) context.getJobDetail().getJobDataMap().get("sysdayMapper");
		newDayInfo();
	}
	
}