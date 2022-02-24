package com.yyl.one.design.adapter;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2022/2/24 14:50
 */
public class AdapterClass extends TargetClass implements Adaptee{
	@Override
	public void specMethod() {
		this.target();
	}

	public void method(){
		//todo something
		this.specMethod();
		//todo something
	}
}
