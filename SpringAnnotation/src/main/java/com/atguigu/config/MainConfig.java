package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
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
                includeFilters = {
                                    //按照注解
                                    //@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                                    ////按照类型
                                    //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                                    //按照正则表达式
                                    //@ComponentScan.Filter(type = FilterType.REGEX, )
                                    //自定义规则
                                    @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                                    }
                )
//扫描多个
//@ComponentScans(value = {
//        @ComponentScan(
//                //扫描指定的包
//                value = "com.atguigu"
//        ),
//        @ComponentScan(
//                //扫描指定的包
//                value = "com.atguigu.bean"
//        )
//})
public class MainConfig {

    //@Bean默认是以方法名当做 bean 的 id
    @Bean("person")
    public Person person_config(){
        return new Person("李四", 24);
    }

}
