package cn.yyl.interview.lock;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/5/6 19:25
 */
public class CopyOneWriteArrayListTest {
	public static void main(String[] args) {
		CopyOnWriteArrayList copyOnWriteArrayList =new CopyOnWriteArrayList();
		copyOnWriteArrayList.add("222");
		copyOnWriteArrayList.get(1);
	}
}
