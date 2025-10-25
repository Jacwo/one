package com.yyl.one.completable;


import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/5/14 22:57
 */
public class CompletableTest {
	public static void main(String[] args) {
		CompletableFuture completableFuture =CompletableFuture.supplyAsync(new Supplier<Object>() {
			@Override
			public Object get() {
				return "2222";
			}
		});
		completableFuture.thenAccept(new Consumer() {
			@Override
			public void accept(Object o) {
				System.out.println(o);
			}
		});


		completableFuture.thenApply(new Function() {
			@Override
			public Object apply(Object o) {
				System.out.println(o);
				return "o";
			}
		});


		completableFuture.thenAccept(new Consumer() {
			@Override
			public void accept(Object o) {
				System.out.println(o);
			}
		});


		completableFuture.thenApply(new Function() {
			@Override
			public Object apply(Object o) {
				System.out.println(o);
				return "o";
			}
		});




		CompletableFuture completableFuture1 =CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				System.out.println("33333");
			}
		});
		completableFuture1.thenRun(new Runnable() {
			@Override
			public void run() {
				System.out.println("4444");
			}
		});


		completableFuture1.thenAccept(new Consumer() {
			@Override
			public void accept(Object o) {
				System.out.println(o);
			}
		});



	}

}
