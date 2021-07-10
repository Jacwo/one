package com.yyl.one.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2021/7/8 下午7:02
 */
public class HashTest {

	public static void main(String[] args) {
		 String key="value";
		 Map<Integer,Object> map=new HashMap<>();
		int i = key.hashCode();
		System.out.println("二进制i---"+Integer.toBinaryString(i));
		map.put(i,"222");
		map.put(i,222);
		System.out.println(i);
		int i1 = i >>> 16;
		System.out.println(i1);
		System.out.println("二进制i1---"+Integer.toBinaryString(i1));

		int i2 = i ^ i1;
		System.out.println(i2);
		System.out.println("二进制i2---"+Integer.toBinaryString(i2));

	}
	/**
	 *
	 */
	/**
	 public HashMap.Node<K,V> getNode(int hash, Object key) {
		HashMap.Node<K,V>[] tab; HashMap.Node<K,V> first, e; int n; K k;
		if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
			 // always check first node
			if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k))))
				return first;
			if ((e = first.next) != null) {
				if (first instanceof HashMap.TreeNode)
					return ((HashMap.TreeNode<K,V>)first).getTreeNode(hash, key);
				do {
					if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
						return e;
				} while ((e = e.next) != null);
			}
		}
		return null;
	}
	 **/
}
