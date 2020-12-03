package com.test.learn.beanDefinitionReader;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.List;

public class MyJsonBeanDefinitionReader extends AbstractBeanDefinitionReader {


    protected MyJsonBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        // 自定义实现
        try {
            final InputStream inputStream = resource.getInputStream();
            // 注册BeanDefinition
            doRegisterBeanDefinition(inputStream);
        } catch (Exception e) {
            throw new BeanDefinitionStoreException(e.getMessage());
        }
        return 0;
    }

    private void doRegisterBeanDefinition(InputStream inputStream) throws IOException, ClassNotFoundException {
        // 从配置文件中加载配置信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        StringBuilder sb = new StringBuilder();
        while(( str = bufferedReader.readLine())!=null){
            sb.append(str);
        }
        // 转化成配置信息
        List<JsonBeanDefinition> jsonBeanDefinitionList = JSONObject.parseArray(sb.toString(),JsonBeanDefinition.class);

        if(!CollectionUtils.isEmpty(jsonBeanDefinitionList)) {
            for (JsonBeanDefinition jsonBeanDefinition : jsonBeanDefinitionList) {
                // 将配置信息转化成BeanDefinition
                BeanDefinition definition = jsonBeanDefinition.toBeanDefinition();
                // 注册BeanDefinition
                this.getRegistry().registerBeanDefinition(jsonBeanDefinition.getName(), definition);
            }
        }
    }
}
