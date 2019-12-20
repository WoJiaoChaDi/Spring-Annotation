package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

    //返回对象
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    //返回类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
