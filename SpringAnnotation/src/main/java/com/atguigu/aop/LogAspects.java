package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用        @AfterReturning("pointCut()")
    //2.其他的切面引用   @AfterThrowing("com.atguigu.aop.pointCut()")
    @Pointcut("execution(* com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut(){};

    @Before("execution(public int com.atguigu.aop.MathCalculator.div(int, int))")
    public void logBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("@Before  " + methodName + "运行开始。。。参数列表是：" + args);
    }

    @After("execution(* com.atguigu.aop.MathCalculator.*(..))")
    public void logAfter(){
        System.out.println("@After运行结束。。。");
    }

    @AfterReturning("pointCut()")
    public void logAfterReturning(){
        System.out.println("@AfterReturning运行正常返回。。。运行结果是{}");
    }

    @AfterThrowing("com.atguigu.aop.LogAspects.pointCut()")
    public void logAfterThrowing(){
        System.out.println("@AfterThrowing运行异常。。。参数列表是{}");
    }

}
