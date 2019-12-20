package com.atguigu.config;

import com.atguigu.bean.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfigFactoryBean {

    //看起来返回的是ColorFactoryBean实例对象，但其实是Color对象
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
