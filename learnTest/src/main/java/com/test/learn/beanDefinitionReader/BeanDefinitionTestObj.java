package com.test.learn.beanDefinitionReader;

public class BeanDefinitionTestObj {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeanDefinitionTestObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
