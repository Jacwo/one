/******************************************************************************
 * Copyright (C) 2016 ShangHai FlashHold Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为上海快仓智能科技开发研制。未经本公司正式书面同意，其他任何个人、团体
 * 不得使用、复制、修改或发布本软件.
 *****************************************************************************/

package cn.yyl.interview.lock;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于Curator实现的分布式锁
 * 
 * @author kim.cheng
 * 
 * @history Aug 17, 2016
 * 
 */
public class CuratorXLock implements Lock {

	private Logger logger = LoggerFactory.getLogger(CuratorXLock.class);

	private InterProcessMutex mutex;

	private String lock;

	private boolean acquired;
	private int lockCounter;

	public CuratorXLock(CuratorFramework client, String lock) {
		this.lock = lock;
		this.mutex = new InterProcessMutex(client, lock);
	}

	@Override
	public boolean acquire() {
		return acquire(-1L);
	}

	@Override
	public boolean acquire(long timeout) {
		try {
			this.acquired = mutex.acquire(timeout, TimeUnit.MILLISECONDS);
			logger.info(String.format("acquire lock '%s' : %b", this.lock, this.acquired));
			if (acquired) {
				lockCounter++;
				return this.acquired;
			}
		} catch (Exception e) {
			logger.error("acquire lock '" + this.lock + "' failure", e);
			throw new RuntimeException("acquire lock '" + this.lock + "' failure", e);
		}
		return false;
	}

	@Override
	public void release() {
		if (!this.acquired || this.lockCounter <= 0) {
			return;
		}
		try {
			if (mutex != null) {
				mutex.release();
				this.lockCounter--;
				// this.acquired = false;
				logger.info("release lock '" + this.lock + "'");
			}
		} catch (Exception e) {
			logger.error("release lock '" + this.lock + "' failure", e);
			throw new RuntimeException("release lock '" + this.lock + "' failure", e);
		}
	}

}
