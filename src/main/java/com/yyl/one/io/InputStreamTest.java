package com.yyl.one.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:yangyuanliang Date:2019-12-25 Time:14:49
 **/
public class InputStreamTest {
  //  BufferedInputStream
    // FileInputStream
    // FilterInputStream
    // InputStream
  public static void main(String[] args) {
	  //Collections.synchronizedMap()
    ExecutorService executorService = Executors.newCachedThreadPool();
    ExecutorService executorService2 = Executors.newFixedThreadPool(2);
    ExecutorService executorService3= Executors.newScheduledThreadPool(2);
    ExecutorService executorService4 = Executors.newSingleThreadExecutor();
    ExecutorService executorService5 = Executors.newWorkStealingPool();

  }
}
