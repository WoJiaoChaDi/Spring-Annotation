package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    //使用@Value赋值
    //1.基本数值
    //2.可以写SpEl表达式： #{}
    //3.可以写${}：取出配置文件中的值（即运行环境变量里面的值，因为配置文件的内容最终都放在运行环境变量中了）
    //            即VM option中： -Dperson.nickName2=小张三

    @Value("张三@Value")
    private String name;
    @Value("#{20-2}")
    private int age;

    //需要再@Configuration 配置类中配置@PropertySource 并指定配置文件
    @Value("${person.nickName2}")
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
