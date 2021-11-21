package com.care.car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SubClass {
	public void subFunc() {
		//Car car = new Controller02();
		
		String path = "classpath:applicationCAR.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		Car car = ctx.getBean("car", Car.class);
		
		System.out.println("서 브 에 서 속 력 을 냅 니 다 !!");
		car.speed();
	}
}
