package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//配置类 等于 以前的配置文件
@Configuration
@ComponentScan(value = "com.atguigu")
public class MainConfig {

    //@Bean默认是以方法名当做 bean 的 id
    @Bean("person")
    public Person person_config(){
        return new Person("李四", 24);
    }

}
