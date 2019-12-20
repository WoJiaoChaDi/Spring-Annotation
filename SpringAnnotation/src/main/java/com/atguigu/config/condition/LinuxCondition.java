package com.atguigu.config.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否linux系统
public class LinuxCondition implements Condition{

    /*
    * ConditionContext：判断条件能使用的上下文条件（环境）
    * AnnotatedTypeMetadata：注释信息
    * */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //是否Linux
        //模拟linux系统，idea中 在运行参数中添加  VM option中添加：-Dos.name=Linux
        //              eclipse中，在VM arguments 中添加：-Dos.name=Linux
        //1.能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前环境信息
        Environment environment = context.getEnvironment();
        //4.获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String osName = environment.getProperty("os.name");
        if(osName.contains("Linux")){
            return true;
        }
        return false;
    }
}
