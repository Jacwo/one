package com.yyl.one.design.facade;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2022/2/24 17:16
 */
public class Client {
	public static void main(String[] args) {
		Facade facade = new Facade(new System1(),new System2() , new System3());
		facade.method();
	}
}
