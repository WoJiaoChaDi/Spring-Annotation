package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationIOCTest2 {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = cxt.getBeanDefinitionNames();
        for (String beanName : definitionNames) {
            System.out.println(beanName);
        }

        //默认是单实例的
        Object bean1 = cxt.getBean(Person.class);
        Object bean2 = cxt.getBean(Person.class);
        System.out.println("@Bean默认是单实例的：" + bean1 == bean2);
    }

}
