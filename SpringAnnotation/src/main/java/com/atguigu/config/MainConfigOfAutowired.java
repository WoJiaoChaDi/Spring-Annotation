package com.atguigu.config;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.config.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//配置类 等于 以前的配置文件
@Configuration

@ComponentScan(
                //扫描指定的包
                value = {"com.atguigu.controller", "com.atguigu.service", "com.atguigu.dao", "com.atguigu.bean"}
                )
public class MainConfigOfAutowired {

    @Bean
    public Car car(){
        return new Car();
    }

    /*
    * @Bean标注的方法创建对象的时候，默认方法参数是从容器中获取
    * */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }

}
