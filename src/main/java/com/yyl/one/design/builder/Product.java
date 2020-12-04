package com.yyl.one.design.builder;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/2 15:41
 * @Description:
 */
public class Product {
	private String A;
	private String B;

	private String C;

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	@Override
	public String toString() {
		return "Product{" +
				"A='" + A + '\'' +
				", B='" + B + '\'' +
				", C='" + C + '\'' +
				'}';
	}
}
