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
			// ��ȡJobExecutionContext�е�service����
			SchedulerContext schCtx = context.getScheduler().getContext();
			// ��ȡSpring�е�������
			ApplicationContext appCtx = (ApplicationContext) schCtx.get("applicationContext");
			sysdayMapper = (SysdayMapper) appCtx.getBean("sysdayMapper");
		} catch (SchedulerException e1) {
			// TODO ��δ�����쳣
			e1.printStackTrace();
		}*/
		sysdayMapper = (SysdayMapper) context.getJobDetail().getJobDataMap().get("sysdayMapper");
		newDayInfo();
	}
	
}