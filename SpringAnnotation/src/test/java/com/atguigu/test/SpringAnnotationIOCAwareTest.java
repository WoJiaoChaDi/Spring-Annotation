package com.atguigu.test;

import com.atguigu.config.MainConfigAware;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationIOCAwareTest {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigAware.class);
        //可以看到Red通过实现ApplicationContextAware接口获得的ioc对象 和 AnnotationConfigApplicationContext 获得的ioc对象是一样的
        System.out.println(cxt);
    }

}
