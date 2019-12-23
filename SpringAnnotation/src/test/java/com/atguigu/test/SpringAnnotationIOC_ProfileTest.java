package com.atguigu.test;

import com.atguigu.config.MainConfigAware;
import com.atguigu.config.MainConfig_Profile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationIOC_ProfileTest {

    //1.运行时候，使用命令行动态参数， -Dspring.profiles.active=test
    //2.用无参的AnnotationConfigApplicationContext构造器，手动设置

    @Test
    public void test01(){
        //ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfig_Profile.class);
        //1.创建一个applicationContext
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        cxt.getEnvironment().setActiveProfiles("test", "dev");
        //3.注册主配置类
        cxt.register(MainConfig_Profile.class);
        //4.启动刷新容器
        cxt.refresh();

        String[] beanDefinitionNames = cxt.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
