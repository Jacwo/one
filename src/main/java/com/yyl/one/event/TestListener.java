package com.yyl.one.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/17 14:44
 * @Description:
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {
	@Override
	public void onApplicationEvent(TestEvent event) {
		TestParam param = (TestParam) event.getSource();
		System.out.println(".......开始.......");
		System.out.println("发送邮件:" + param.getEmail());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(".......结束.....");
	}
}
