package com.atguigu.config;

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
                value = {"com.atguigu.controller", "com.atguigu.service", "com.atguigu.dao"}
                )
public class MainConfigOfAutowired {

}
