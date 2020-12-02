package com.test.learn.beanFactoryPostprocesser;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLearn1 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:conf/beanFactoryPostProcessor/myBeanFactoryPostProcessor.xml");
		TestObj obj = (TestObj) applicationContext.getBean("testObj2");
		System.out.println(obj);
	}
}
