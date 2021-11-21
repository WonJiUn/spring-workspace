package com.care.root;

public class MainClass {
	public static void main(String[] args) {
		STBean stBean = new STBean();
		stBean.setName("홍길동");
		stBean.setAge(20);
		
		stBean.setSt(new Student());
		stBean.namePrint();
		stBean.agePrint();
	}
}
