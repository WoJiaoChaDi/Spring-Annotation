package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
 * AOP:动态代理
 *       指在程序运行期间，动态的将某段代码切入到指定方法、指定位置，进行运行的编程方式
 *
 * 1.导入aop模块：Spring AOP:(spring-aspects)
 * 2.定义一个业务逻辑类（MathCalculator）：在业务逻辑运行的时候将日志进行打印（方法运行之前、方法运行结束、方法出现异常、xxx）
 * 3.定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行
 *      通知方法：
 *          前置通知（@Before）：logStart：在目标方法（div）运行前运行
 *          后置通知（@After）：logEnd：在目标方法（div）运行之后运行
 *          返回通知（@AfterReturning）：logReturn：在目标方法（div）正常返回之后运行
 *          异常通知（@AfterThrowing）：logException：在目标方法（div）出现异常以后运行
 *          环绕通知（@Around）：动态代理，手动推进目标方法运行（joinPoint.procced()）
* 4.给切面类的方法标注何时何地运行（通知注解）
* 5.将切面类 和 业务逻辑类（模板方法所在类） 都加载到容器中
* 6.必须告诉Spring哪个是切面类（给切面类加注解@Aspect）
* 7.给配置类中加@EnableAspectJAutoProxy ，开启基于注解的aop模式
*       在Spring中有很多的@EnableXXXX；
 *
 * */
@EnableAspectJAutoProxy
@Configuration
public class MainConfig_AOP {

    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
