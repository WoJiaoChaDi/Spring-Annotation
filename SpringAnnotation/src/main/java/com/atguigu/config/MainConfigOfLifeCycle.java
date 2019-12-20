package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 1.构造方法
*   单实例：在容器启动的时候执行
*   单实例（懒加载）：在容器第一次获取的时候执行
*   多实例：在容器每次获取的时候执行
*
* 2.初始化方法：对象创建完成，并赋值好后（跟构造方法的 单实例、多实例对应）
*       适合定义一些：连接、数据源初始化
*
* 3.销毁方法：单实例在容器关闭的时候执行，多实例容器不会处理
*       适合定义一些：连接、数据源的关闭
* */

@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}