package com.care.car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//Car car = new Controller02();
		String path = "classpath:applicationCAR.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		Car car = ctx.getBean("car", Car.class);
		
		System.out.println("메인에서 속력을 냅니다!!");
		car.speed();
		SubClass sc = new SubClass();
		sc.subFunc();
	}
}
