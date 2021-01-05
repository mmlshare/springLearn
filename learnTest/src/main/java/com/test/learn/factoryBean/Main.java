package com.test.learn.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:conf/factoryBean/factoryBean.xml");
        Object o = classPathXmlApplicationContext.getBean("myFactoryBean");
    }
}
