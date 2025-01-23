package com.yyl.one.current;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.*;

/**
 * @Author:yangyuanliang
 * @Date:2021/7/12 10:44
 * @Description:
 */
public class BlockedQueueTest {
	public static void main(String[] args) throws InterruptedException {

		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext();

		//有界队列
		ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue(1000);
		//无界队列
		LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

		ExecutorService executorService = new ThreadPoolExecutor(3, 9, 30,
				TimeUnit.SECONDS,
				arrayBlockingQueue);
		while (true) {
			if (arrayBlockingQueue.take() != null) {
				executorService.execute(arrayBlockingQueue.take());

			}
		}




	}
}
