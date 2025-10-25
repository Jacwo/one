package com.yyl.one.completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/9/1 23:08
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<Runnable> task = new LinkedBlockingQueue<>(100);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 8, 1800, TimeUnit.SECONDS,
				task, new ThreadPoolExecutor.CallerRunsPolicy());
		task.add(() -> System.out.println("222"));
		threadPoolExecutor.execute(task.take());
		String s = "";
		s.length();
		char[] chars = s.toCharArray();
		int length = chars.length;
		List list =new ArrayList();
		list.size();
		



	}
}
