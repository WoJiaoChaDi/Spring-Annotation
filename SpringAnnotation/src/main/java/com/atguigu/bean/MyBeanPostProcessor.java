package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//后置处理器：初始化前后进行处理工作
//只需要注入到ioc容器中就可以运行
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcess**Before**Initialization..." + "BeanName：" + beanName + "   Bean：" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcess**After**Initialization..." + "BeanName：" + beanName + "   Bean：" + bean);
        return bean;
    }
}
