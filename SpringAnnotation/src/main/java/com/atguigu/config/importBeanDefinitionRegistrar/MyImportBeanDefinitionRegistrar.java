package com.atguigu.config.importBeanDefinitionRegistrar;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

    /*
    * AnnotationMetadata：当前类的注解信息
    * BeanDefinitionRegistry：BeanDefinition注册类：
    *                   把所有需要添加到容器中的bean：调用
    *                   BeanDefinitionRegistry.registerBeanDefinition 手工注册
    * */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean definition = registry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean definition2 = registry.containsBeanDefinition("com.atguigu.bean.Blue");
        if(definition && definition2){
            //指定bean定义信息：bean的类型等等
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean：指定bean名
            registry.registerBeanDefinition("rainBowWithRedAndBlue", rootBeanDefinition);
        }

    }
}
