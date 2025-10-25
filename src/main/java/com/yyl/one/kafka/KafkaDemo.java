package com.yyl.one.kafka;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/9/14 17:07
 */
public class KafkaDemo {
	@KafkaListener(topics = "test-topic", groupId = "my-group")
	public void consume(String message) {
		

	}
}
