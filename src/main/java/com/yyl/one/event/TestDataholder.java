package com.yyl.one.event;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/3/18 17:54
 */
public class TestDataholder implements Cloneable{
	int a[] = {1,2,3};




	public static void main(String[] args) throws CloneNotSupportedException {
		TestDataholder testDataholder =new TestDataholder();
		TestDataholder clone = (TestDataholder) testDataholder.clone();
		System.out.println(testDataholder.a[0]);
		clone.a[0] = 100;
		System.out.println(testDataholder.a[0]);

		System.out.println(getPrice(10));

	}

	public static int getPrice(int n){
		if(n == 1){
			return 10;
		}
		return getPrice(n-1)+2;
	}
}
