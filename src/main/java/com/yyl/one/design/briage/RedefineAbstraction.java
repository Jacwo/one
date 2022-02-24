package com.yyl.one.design.briage;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2022/2/24 16:32
 */
public class RedefineAbstraction  extends Abstraction{
	public RedefineAbstraction(Implementor implementor){
		super.implementor = implementor;
	}
	@Override
	void method() {
		super.implementor.impl();
	}
}
