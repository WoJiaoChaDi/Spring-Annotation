package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

public class SpringAnnotationIOCTest3 {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfig3.class);

        //动态获取操作系统
        Environment environment = cxt.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("osName is :" + osName);

        String[] beanNames = cxt.getBeanNamesForType(Person.class);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Map<String, Person> personMap = cxt.getBeansOfType(Person.class);
        System.out.println(personMap);
    }
}
