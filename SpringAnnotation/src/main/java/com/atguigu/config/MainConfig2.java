package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig2 {

    @Bean("person")
    public Person person(){
        return new Person("王五", 25);
    }
}
