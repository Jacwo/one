package com.yyl.one.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/17 14:46
 * @Description:
 */
@Component
public class TestPublish implements ApplicationEventPublisherAware {
	private static ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		TestPublish.applicationEventPublisher=applicationEventPublisher;
	}
	public  void  publishEvent(ApplicationEvent communityArticleEvent) {
		applicationEventPublisher.publishEvent(communityArticleEvent);
	}
}
