package cn.yyl.interview.classloader;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/3/21 10:26
 */
public class TestClassLoder extends ClassLoader{
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		findLoadedClass(name);
		return super.loadClass(name);
	}
}
