package cn.yyl.interview.lock;

/**
 * ��������
 *
 * @author kim.cheng
 *
 * @history Aug 17, 2016
 *
 */
public abstract class LockFactory {

	private static LockFactory instance;

	/**
	 * ������������ʵ��
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
	 * ��ȡ��ռ������
	 *
	 * @param lockName
	 * @return
	 */
	public abstract Lock getXLock(String lockName);

	/**
	 * ������
	 * ͨ��ǰ׺�͵���id����lockName
	 * @param lockNamePrefix
	 * @param id
	 * @return
	 */
	public abstract Lock getXLock(LockNamePrefix lockNamePrefix , String id);
}
