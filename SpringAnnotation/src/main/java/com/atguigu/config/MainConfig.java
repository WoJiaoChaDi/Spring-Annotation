package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类 等于 以前的配置文件
@Configuration
public class MainConfig {

    @Bean
    public Person person_config(){
        return new Person("李四", 24);
    }

}
