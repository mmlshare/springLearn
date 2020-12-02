package com.test.learn.beanFactoryPostprocesser;

public class TestObj {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void init(){
		System.out.println("testObj 初始化");
	}

	@Override
	public String toString() {
		return "TestObj{" +
				"name='" + name + '\'' +
				'}';
	}
}
