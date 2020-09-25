package com.test.learn.learn1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLearn1 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:conf/learn1/learnTest1.xml");
		TestObj obj = (TestObj) applicationContext.getBean("testObj");
		System.out.println(obj);
	}
}
