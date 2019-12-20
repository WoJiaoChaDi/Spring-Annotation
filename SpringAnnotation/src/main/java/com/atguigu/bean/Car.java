package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements InitializingBean, DisposableBean{

    public Car() {
        System.out.println("Car constructor...");
    }

    public void initMethod(){
        System.out.println("Car init...");
    }

    public void destroyMethod(){
        System.out.println("Car destroy...");
    }

    //通过实现InitializingBean接口，来实现初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car InitializingBean.afterPropertiesSet...");
    }

    //通过实现DisposableBean接口，来实现销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Car DisposableBean.destroy...");
    }

}
