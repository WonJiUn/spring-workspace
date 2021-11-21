package com.care.di_test02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path="classpath:application_test02.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		SaveClass saveclass = ctx.getBean("save",SaveClass.class);
		
		//Scanner input = new Scanner(System.in);
		//System.out.println("수 입력");
		//saveclass.setNum1(input.nextInt());
		
		saveclass.scan();
		saveclass.operationClass();
		saveclass.printClass();
	}
}
