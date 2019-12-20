package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    /*
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * SCOPE_SINGLETON：单实例：ioc容器启动的时候，创建了该对象
     * SCOPE_PROTOTYPE：多实例：ioc容器获取的时候，创建对象
     * SCOPE_REQUEST：同一次请求一个实例
     * SCOPE_SESSION：同一个session，创建一个实例
     *
     * */
    //@Scope("prototype")//默认是单实例，这里改成多实例
    @Lazy   //针对单实例，懒加载：启动的时候不加载对象，第一次get的时候创建对象
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person");
        return new Person("王五", 25);
    }
}
