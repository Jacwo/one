package com.yyl.one.design.briage;

/**
 * @author yangyuanliang
 * @version 1.9 桥接
 * @date 2022/2/24 16:31
 */
public class Client {
	public static void main(String[] args) {
		ConcreteImplementorA concreteImplementorA =new ConcreteImplementorA();
		RedefineAbstraction redefineAbstraction =new RedefineAbstraction(concreteImplementorA);
		redefineAbstraction.method();
	}
}
