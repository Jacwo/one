package cn.yyl.interview.lock;

/**
 * 锁工厂类
 *
 * @author kim.cheng
 *
 * @history Aug 17, 2016
 *
 */
public abstract class LockFactory {

	private static LockFactory instance;

	/**
	 * 返回锁工厂类实例
	 *
	 * @return
	 */
	public synchronized static LockFactory getInstance() {
		if(instance == null){
			instance = new CuratorLockFactoryImpl();
		}
		return instance;
	}

	/**
	 * 获取独占锁对象
	 *
	 * @param lockName
	 * @return
	 */
	public abstract Lock getXLock(String lockName);

	/**
	 * 单据锁
	 * 通过前缀和单据id生成lockName
	 * @param lockNamePrefix
	 * @param id
	 * @return
	 */
	public abstract Lock getXLock(LockNamePrefix lockNamePrefix , String id);
}
