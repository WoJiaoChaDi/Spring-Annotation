package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    //@Resource(JSR250规范的注解)
    @Resource(name="bookDao2")
    private BookDao bookDao2;

    //@Inject(JSR330规范的注解)  依赖  javax.inject 包
    @Inject
    private BookDao bookDao3;

    public void print(){
        System.out.println(bookDao);
    }
}
