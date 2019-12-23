package com.atguigu.test;

import com.atguigu.bean.Car;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.AnnotationMetadata;

public class SpringAnnotationIOCOfLiceCycleTest {

    @Test
    public void test01(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

        System.out.println("========自己创建只会执行构造方法=========");
        Car car = new Car();
        System.out.println("========自己创建只会执行构造方法=========");

        //容器关闭
        cxt.close();
    }
}
