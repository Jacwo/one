package com.yyl.one.design.builder;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/2 15:41
 * @Description:
 */
public abstract class Builders {
	protected Product product =new Product();
	abstract void buildA();

	abstract void buildB();

	abstract void buildC();

	public Product getResult(){
		return product;
	}
}
