package com.yyl.one.stringg;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/3/10 22:04
 */
public class StringTest {
	public static final String test = "java";


	public static void main(String[] args) {
		String s = "test";
		String s2 =new String("test");

		String s3 =new StringBuilder("ja").append("va").toString();
		String s4 = s3.intern();
 		System.out.println(s == test);
		System.out.println(s2 == test);
		System.out.println(s == s2);
		System.out.println(s3 == test);
		System.out.println(test == s4);

	}
}
