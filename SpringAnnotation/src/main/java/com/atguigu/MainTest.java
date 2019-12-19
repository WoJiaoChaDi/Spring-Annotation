package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        //通过配置文件获取
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        //通过配置类获取
        ApplicationContext ctx_config = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person_config = (Person) ctx_config.getBean("person");
        System.out.println(person_config);

    }
}
