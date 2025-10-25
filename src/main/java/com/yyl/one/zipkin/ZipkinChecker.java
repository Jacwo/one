package com.yyl.one.zipkin;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/10/23 00:02
 */
@Component
public class ZipkinChecker {

	@EventListener(ApplicationReadyEvent.class)
	public void check() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity(
					"http://localhost:9411/health", String.class);
			System.out.println("✅ Zipkin 连接正常");
		} catch (Exception e) {
			System.out.println("❌ Zipkin 连接失败: " + e.getMessage());
		}
	}
}