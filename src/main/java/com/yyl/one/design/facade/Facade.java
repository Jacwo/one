package com.yyl.one.design.facade;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2022/2/24 17:15
 */
public class Facade {
	System1 system1 ;
	System2 system2 ;
	System3 system3 ;

	public Facade(System1 system1 , System2 system2 ,System3 system3){
		this.system1 =system1;
		this.system2 =system2;
		this.system3 =system3;
	}
	public void method(){
		system1.method1();
		system2.method2();
		system3.method3();
	}
}
