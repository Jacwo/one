package com.yyl.one.design.builder;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/2 15:47
 * @Description:
 */
public class Client {
	public static void main(String[] args) {
		Builders builder=new ConcreteABuilder();
		builder.buildA();
		builder.buildB();

		Product result = builder.getResult();
		System.out.println(result);
	}
}
