package com.test.learn.paramelement;

import com.test.learn.beanFactoryPostprocesser.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class ParamElement {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:conf/spring.xml");
        //System.out.println("容器初始化完毕");
        //TestObj obj = applicationContext.getBean("testObj",TestObj.class);
    }
}
