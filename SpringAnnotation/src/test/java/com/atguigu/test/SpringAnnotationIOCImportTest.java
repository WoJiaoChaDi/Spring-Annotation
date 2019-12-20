package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigConditional;
import com.atguigu.config.MainConfigImport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class SpringAnnotationIOCImportTest {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigImport.class);
        String[] beanDefinitionNames = cxt.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }
}
