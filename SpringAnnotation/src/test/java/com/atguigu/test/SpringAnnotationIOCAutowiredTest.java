package com.atguigu.test;

import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

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
        BookService bookService = (BookService) cxt.getBean("bookService");
        bookService.print();

        BookDao bookDao = (BookDao) cxt.getBean("bookDao");
        System.out.println(bookDao);


    }
}
