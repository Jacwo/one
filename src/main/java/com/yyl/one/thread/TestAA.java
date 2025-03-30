package com.yyl.one.thread;

import java.util.concurrent.Semaphore;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/2/27 17:49
 */
public class TestAA {
	private int n;
	Semaphore semaphore =new Semaphore(1);
	Semaphore semaphore2 =new Semaphore(1);

	Semaphore semaphore3 =new Semaphore(1);

	public TestAA(int n){
		this.n = n;
	}

	public void zero(){
		try {
			for(int i=0;i<n;i++){
				semaphore.acquire();
				System.out.print("0");
				if(i%2==0 && i!=0){
					semaphore2.release();

				}else if(i%2==1 && i!=1){
					semaphore3.release();

				}

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void odd(){
		for (int i=1; i <= n; i++) {
			if(i%2 == 1){
				try {
					semaphore2.acquire();
					System.out.print(i);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void even(){
		for (int i=1; i <= n; i++) {
			if(i%2 == 0){
				try {
					semaphore3.acquire();
					System.out.print(i);
					semaphore.release();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}


	public static void main(String[] args) {
		TestAA ts =new TestAA(10);
		Thread thread =new Thread(new Runnable() {
			@Override
			public void run() {
				ts.zero();
			}
		});


		Thread thread2 =new Thread(new Runnable() {
			@Override
			public void run() {
				ts.odd();
			}
		});


		Thread thread3 =new Thread(new Runnable() {
			@Override
			public void run() {
				ts.even();
			}
		});

		thread.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread3.start();

	}
}
