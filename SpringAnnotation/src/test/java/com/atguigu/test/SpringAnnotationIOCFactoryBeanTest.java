package com.atguigu.test;

import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationIOCFactoryBeanTest {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigFactoryBean.class);
        String[] definitionNames = cxt.getBeanDefinitionNames();
        for (String beanName : definitionNames) {
            System.out.println(beanName);
        }

        Object colorFactoryBean = cxt.getBean("colorFactoryBean");
        System.out.println("colorFactoryBean实际的类型是：" + colorFactoryBean.getClass());

        //获取真正的FactoryBean
        Object factoryBean = cxt.getBean("&colorFactoryBean");
        System.out.println("获取真正的FactoryBean：");
    }
}
