package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

//配置类 等于 以前的配置文件
@Configuration
//通过@PropertySource 读取外部配置文件中的k/v包邮到运行的环境变量中
@PropertySource(value={"classpath:/person.properties"})
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }

}
