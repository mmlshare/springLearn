package com.test.learn.beanDefinitionReader;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;


public class ClassPathJsonApplicationContext extends AbstractApplicationContext {
    // 存放json配置路径
    private String[] location;

    private volatile DefaultListableBeanFactory beanFactory;

    public ClassPathJsonApplicationContext(String... location) {
        this.location = location;
        refresh();
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
            //创建一个beanFactory
            DefaultListableBeanFactory beanFactory = createBeanFactory();
            // 设置容器的ID
            beanFactory.setSerializationId(getId());
            //加载BeanDefinition
            loadBeanDefinitions(beanFactory);
            this.beanFactory = beanFactory;
    }

    private void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        MyJsonBeanDefinitionReader myJsonBeanDefinitionReader = new MyJsonBeanDefinitionReader(beanFactory);
        myJsonBeanDefinitionReader.loadBeanDefinitions(location);
    }

    private DefaultListableBeanFactory createBeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory(getInternalParentBeanFactory());;
        return defaultListableBeanFactory;
    }

    @Override
    protected void closeBeanFactory() {
        DefaultListableBeanFactory beanFactory = this.beanFactory;
        if (beanFactory != null) {
            beanFactory.setSerializationId(null);
            this.beanFactory = null;
        }
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return this.beanFactory;
    }
}
