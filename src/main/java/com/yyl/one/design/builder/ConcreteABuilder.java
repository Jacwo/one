package com.yyl.one.design.builder;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/2 15:43
 * @Description:
 */
public class ConcreteABuilder extends Builders {
	@Override
	void buildA() {
		product.setA("A");
	}

	@Override
	void buildB() {
		product.setB("B");

	}

	@Override
	void buildC() {
		product.setC("C");

	}
}
