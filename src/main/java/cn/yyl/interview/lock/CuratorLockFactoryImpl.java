/******************************************************************************
 * Copyright (C) 2016 ShangHai FlashHold Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ�Ϻ�������ܿƼ��������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ�����
 * ����ʹ�á����ơ��޸Ļ򷢲������.
 *****************************************************************************/

package cn.yyl.interview.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;


/**
 * Curator����������
 * 
 * @author kim.cheng
 * 
 * @history Aug 17, 2016
 * 
 */
public class CuratorLockFactoryImpl extends LockFactory {

	private CuratorFramework client;

	private static final String X_LOCK_PATH = "/locks/x_lock/";

	public CuratorLockFactoryImpl() {
		this.client = CuratorFrameworkFactory.builder().connectString("127.0.0.1")
		.connectionTimeoutMs(300)
		.sessionTimeoutMs(30000)
		.retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
		client.start();
	}

	@Override
	public Lock getXLock(String lockName) {
		return new CuratorXLock(client, X_LOCK_PATH + lockName);
	}

	@Override
	public Lock getXLock(LockNamePrefix lockNamePrefix, String id) {
		String lockName  = String.format("%s_%s", lockNamePrefix.name(), id);
		return getXLock(lockName);
	}
}
