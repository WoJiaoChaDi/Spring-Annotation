package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类 等于 以前的配置文件
@Configuration
@ComponentScan(
                //扫描指定的包
                value = "com.atguigu",
                //排除部分扫描，排除注解，排除Controller这个注解
                //excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})}
                //指定部分扫描，需要关闭默认的  userDefaultFilters
                useDefaultFilters = false,
                includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}
                )
public class MainConfig {

    //@Bean默认是以方法名当做 bean 的 id
    @Bean("person")
    public Person person_config(){
        return new Person("李四", 24);
    }

}
