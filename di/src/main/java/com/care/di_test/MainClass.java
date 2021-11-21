package com.care.di_test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path="classpath:application_test.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		PrintBean printBean = ctx.getBean("pb01",PrintBean.class);
		printBean.stringPrint();
	}
}
