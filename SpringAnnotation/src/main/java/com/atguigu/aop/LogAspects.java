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
    public void logAfter(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("@After  " + methodName + "运行结束。。。参数列表是：" + args);
    }

    //JoinPoint 一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("@AfterReturning  " + methodName + "运行正常返回。。。参数列表是{" + args + "};运行结果是{" + result + "}");
    }

    @AfterThrowing(value = "com.atguigu.aop.LogAspects.pointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("@AfterThrowing  " + methodName + "运行异常。。。参数列表是{" + args + "}" + "异常是：" + exception);
    }

}
