package com.dream.interview4.aopreview.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author : huzejun
 * @Date: 2024/9/14-5:45
 */
@Aspect
@Component
public class PayAspect {

    @Before("execution(public void com.dream.interview4.aopreview.PayServiceImpl.pay(..))")
    public void beforeNotify()
    {
        System.out.println("--------@Before前置通知");
    }

    @After("execution(public void com.dream.interview4.aopreview.PayServiceImpl.pay(..))")
    public void afterNotify()
    {
        System.out.println("-------@After后置通知");
    }

    @AfterReturning("execution(public void com.dream.interview4.aopreview.PayServiceImpl.pay(..))")
    public void afterReturningNotify()
    {
        System.out.println("----------@AfterReturning返回通知");
    }

    @AfterThrowing("execution(public void com.dream.interview4.aopreview.PayServiceImpl.pay(..))")
    public void afterThrowingNotify() {
        System.out.println("----------@AfterThrowing异常通知");
    }

    @Around("execution(public void com.dream.interview4.aopreview.PayServiceImpl.pay(..))")
    public Object aroundNotify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;

        System.out.println("----------@Around环绕通知AAA");
        retValue = proceedingJoinPoint.proceed();   //放行
        System.out.println("----------@Around环绕通知BBB");

        return retValue;
    }

}
