package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean{

    public Car() {
        System.out.println("Car constructor...");
    }

    //1.在@Bean中指定 初始化、销毁 方法
    public void initMethod(){
        System.out.println("Car 1.init...");
    }

    public void destroyMethod(){
        System.out.println("Car 1.destroy...");
    }

    //2.通过实现InitializingBean接口\DisposableBean接口  来实现初始化方法\销毁方法
    //通过实现InitializingBean接口，来实现初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car 2.InitializingBean.afterPropertiesSet...");
    }

    //通过实现DisposableBean接口，来实现销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Car 2.DisposableBean.destroy...");
    }

    //3.
    @PostConstruct
    public void initPostConstruct(){
        System.out.println("Car 3.PostConstruct.initPostConstruct...");
    }

    @PreDestroy
    public void destroyPreDestroy(){
        System.out.println("Car 3.PreDestroy.destroyPreDestroy...");
    }


}
