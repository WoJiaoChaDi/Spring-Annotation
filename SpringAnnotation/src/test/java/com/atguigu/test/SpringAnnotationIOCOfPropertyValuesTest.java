package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class SpringAnnotationIOCOfPropertyValuesTest {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

        Environment environment = cxt.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println("配置文件中的person.nickName最终加载到运行时环境中了：" + property);

        Person person = (Person) cxt.getBean("person");
        System.out.println(person);
    }
}
