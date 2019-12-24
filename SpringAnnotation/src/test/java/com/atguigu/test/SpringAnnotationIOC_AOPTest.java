package com.atguigu.test;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfig_AOP;
import com.atguigu.config.MainConfig_Profile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationIOC_AOPTest {

    //1.运行时候，使用命令行动态参数， -Dspring.profiles.active=test
    //2.用无参的AnnotationConfigApplicationContext构造器，手动设置

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfig_AOP.class);
        MathCalculator mathCalculator = (MathCalculator) cxt.getBean("mathCalculator");
        int div = mathCalculator.div(8, 0);
    }

}
