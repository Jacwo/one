package com.yyl.one.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/1/25 11:27
 */
public class DealLockTest {
	private static Object lockA =new Object();
	private static Object lockB =new Object();
	public static void alock(){
		synchronized (lockA){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lockB){
				System.out.println("get lock b");
			}
		}
	}

	public static void block(){
		synchronized (lockB){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (lockA){
				System.out.println("get lock b");
			}
		}
	}


	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				alock();
			}
		});
		thread.setName("my thread 1 ....");

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				block();

			}
		});
		thread2.setName("my thread 2 ....");
		thread.start();
		thread2.start();
	}


}
