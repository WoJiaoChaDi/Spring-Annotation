package com.atguigu.test;

import com.atguigu.config.MainConfig;
import com.atguigu.dao.BookDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationIOCTest {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = cxt.getBeanDefinitionNames();
        for (String beanName : definitionNames) {
            System.out.println(beanName);
        }
    }
}
