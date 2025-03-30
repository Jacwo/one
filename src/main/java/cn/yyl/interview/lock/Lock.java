/******************************************************************************
 * Copyright (C) 2016 ShangHai FlashHold Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为上海快仓智能科技开发研制。未经本公司正式书面同意，其他任何个人、团体
 * 不得使用、复制、修改或发布本软件.
 *****************************************************************************/

package cn.yyl.interview.lock;

/**
 * 锁对象
 * 
 * @author kim.cheng
 * 
 * @history Aug 17, 2016
 * 
 */
public interface Lock {
	/**
	 * 获得锁，非阻塞方法
	 * 
	 * @return
	 */
	boolean acquire();

	/**
	 * 获得锁 
	 * @param timeout long 超时时间，单位毫秒
	 * 
	 * @return
	 */
	boolean acquire(long timeout);

	/**
	 * 释放锁
	 * 
	 * @return
	 */
	void release();
}
