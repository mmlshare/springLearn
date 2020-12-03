package com.test.learn.beanDefinitionReader;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class JsonBeanDefinition {
    /**
     * bean 名称
     */
    private String name;
    /**
     * class
     */
    private String clazz;
    /**
     * 属性
     */
    private Map<String,Properties> properties;

    public static class Properties{
        /**
         * 值
         */
        private String value;
        /**
         * 是否是bean引用
         */
        private boolean isRef=false;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isRef() {
            return isRef;
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Map<String, Properties> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Properties> properties) {
        this.properties = properties;
    }

    /**
     * 将配置转化成BeanDefinition
     * @return
     * @throws ClassNotFoundException
     */
    BeanDefinition toBeanDefinition() throws ClassNotFoundException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Class.forName(clazz));

        if(!CollectionUtils.isEmpty(properties)){
            for(Map.Entry<String,Properties> entry:properties.entrySet()){
                // 如果是引用
                if(entry.getValue().isRef()){
                    builder.addPropertyReference(entry.getKey(),entry.getValue().value);
                }else{
                    builder.addPropertyValue(entry.getKey(),entry.getValue().value);
                }
            }
        }
        return builder.getBeanDefinition();

    }
}
