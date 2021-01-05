package com.test.learn.factoryBean;

import com.test.learn.circleReference.A;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<A> {
    @Override
    public A getObject() throws Exception {
        return new A();
    }

    @Override
    public Class<?> getObjectType() {
        return A.class;
    }
}
