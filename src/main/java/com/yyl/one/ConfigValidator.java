package com.yyl.one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/10/23 14:40
 */
@Component
public class ConfigValidator implements CommandLineRunner {

	private final Environment environment;

	public ConfigValidator(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== 配置验证开始 ===");

		// 检查关键配置
		checkProperty("server.port");
		checkProperty("spring.application.name");
		checkProperty("management.tracing.sampling.probability");

		System.out.println("=== 配置验证结束 ===");
	}

	private void checkProperty(String key) {
		String value = environment.getProperty(key);
		System.out.println(key + " = " + (value != null ? value : "未设置"));
	}
}