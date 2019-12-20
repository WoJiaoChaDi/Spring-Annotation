package com.atguigu.test;

import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.inject.Inject;

public class SpringAnnotationIOCAutowiredTest {

    @Test
    public void test01(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        //Autowired 与 ioc 的bean是同一个bean
        //Autowired：
        //          1.默认按照类型注入
        //          2.如果同类型有多个，则按照属性的名字进行注入
        //          3.@Qualifier("bookDao2") 强制指定注入的bean名称
        //          4.@Autowired(required=false) 允许容器中没有bean，则不自动注入
        //          5.@Primary：让Sping自动注入的时候，首选装配的bean

        //Spring还支持使用@Resource 和 @Inject 注解，两者都是Java规范

        //@Resource:
        //    可以和@Autowired一样实现自动装备功能，默认是按照组件名称进行装配的。
        //    不支持@Primary，也不支持@Autowired(required=false)

        //@Inject
        //    需要导入javax.inject的包，和Autowired一样。没有@Autowired(required=false)功能
        //    @Autowired是Spring定义的，而@Resource、@Inject是Java规范
        BookService bookService = (BookService) cxt.getBean("bookService");
        bookService.print();

        BookDao bookDao = (BookDao) cxt.getBean("bookDao");
        System.out.println(bookDao);


    }
}
