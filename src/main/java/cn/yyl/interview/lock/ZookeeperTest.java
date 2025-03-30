package cn.yyl.interview.lock;

import org.apache.zookeeper.ZooKeeper;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/3/19 18:45
 */
public class ZookeeperTest {
	public static void main(String[] args) {
		//ZooKeeper zooKeeper =new ZooKeeper();
		Lock lock = LockFactory.getInstance().getXLock(LockNamePrefix.LOCK_ORDER.name());
		lock.acquire(200);

	}
}
