package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Boss {

    //@Autowired
    private Car car;

    public Boss(){
        System.out.println("Boss无参构造器...");
    }

    //Autowire加在有参构造器中，通过扫包获得的bean自动是通过有参构造器创建的，并且会把有参构造器的参数bean注入进去
    //public Boss(@Autowired Car car) {
    //    this.car = car;
    //    System.out.println("Boss有参构造器...");
    //}

    //@Autowired
    //如果只有一个有参构造器（没有无参构造器，则默认在该有参构造器上加@Autowired）
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss有参构造器...");
    }

    //Autowire加载set方法上，会自动注入set方法参数的bean
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
