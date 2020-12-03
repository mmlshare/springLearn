package com.test.learn.beanDefinitionReader;

public class TestRun {
    public static void main(String[] args) {
        ClassPathJsonApplicationContext applicationContext = new ClassPathJsonApplicationContext("classpath:conf/beandefinitionReader/beanDefinition.json");
        System.out.println(applicationContext.getBean("testBean"));
    }
}
