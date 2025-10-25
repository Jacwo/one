package com.yyl.one.redis;

import org.redisson.api.*;
import org.redisson.api.redisnode.BaseRedisNodes;
import org.redisson.api.redisnode.RedisNodes;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/5/2 10:35
 */
public class RedissonTest {
	@Autowired
	private static RedissonClient redissonClient;
	public static void main(String[] args) {
		//redissonClient.
	}
}
