package com.yyl.one.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/4/27 09:15
 */
class RedisDelayQueue {

	private static final String DELAY_QUEUE_KEY = "delay_queue";
	private final JedisPool jedisPool;

	public RedisDelayQueue(JedisPool pool) {
		this.jedisPool = pool;
	}

	// 添加延时任务
	public void addTask(String taskId, long delaySeconds) {
		try (Jedis jedis = jedisPool.getResource()) {
			long executeTime = System.currentTimeMillis() + delaySeconds * 1000;
			jedis.zadd(DELAY_QUEUE_KEY, executeTime, taskId);
		}
	}

	// 轮询处理到期任务
	public void pollTasks() {
		try (Jedis jedis = jedisPool.getResource()) {
			long now = System.currentTimeMillis();
			// 查询score<=当前时间的任务
			Set<Tuple> tasks = jedis.zrangeByScoreWithScores(DELAY_QUEUE_KEY, 0, now);

			for (Tuple task : tasks) {
				String taskId = task.getElement();
				double score = task.getScore();
				// 原子性移除任务
				if (jedis.zrem(DELAY_QUEUE_KEY, taskId) > 0) {
					handleTask(taskId, score);
				}
			}
		}
	}

	// 任务处理逻辑（需业务方实现）
	private void handleTask(String taskId, double executeTime) {
		System.out.printf("处理任务: %s (计划执行时间: %d)%n",
				taskId, (long) executeTime);
		// 实际业务逻辑实现位置
	}
}


class Scheduler {
	private final RedisDelayQueue delayQueue;
	private final ScheduledExecutorService executor;

	public Scheduler(JedisPool pool) {
		this.delayQueue = new RedisDelayQueue(pool);
		this.executor = Executors.newSingleThreadScheduledExecutor();
	}

	public void start() {
		// 每5秒执行一次轮询
		executor.scheduleWithFixedDelay(() -> {
			try {
				delayQueue.pollTasks();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 0, 5, TimeUnit.SECONDS);
	}

	public void shutdown() {
		executor.shutdown();
	}
}


class Main {
	public static void main(String[] args) {
		JedisPool pool = new JedisPool("127.0.0.1", 6379);
		RedisDelayQueue queue = new RedisDelayQueue(pool);
		Scheduler scheduler = new Scheduler(pool);

		// 添加测试任务（30秒后执行）
		queue.addTask("ORDER_1001", 30);
		queue.addTask("NOTICE_2001", 60);

		// 启动任务调度
		scheduler.start();

		// 保持程序运行
		try {
			Thread.sleep(120_000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			scheduler.shutdown();
			pool.close();
		}
	}
}
