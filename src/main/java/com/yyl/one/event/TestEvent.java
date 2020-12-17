package com.yyl.one.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/17 14:42
 * @Description:
 */
public class TestEvent extends ApplicationEvent {
	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	private TestParam testParam;
	public TestEvent(TestParam source) {
		super(source);
		this.testParam=source;
	}
}
