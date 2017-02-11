package com.syz.test.aopAnotion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * Created by Administrator on 2016/12/17.
 */
@Order(2)
@Aspect
public class MyInterceptor {
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    String strLog = null;
    @Pointcut("execution(* com.syz.test.service.*.*(..))")

    //声明一个切入点
    private void anyMethod() {
        System.out.println("我是anyMethod");
    }

    @Before("anyMethod() && args(name)")//声明前置通知
    public void doBefore(String name) {
        System.out.println("前置通知");
        System.out.println("--- doBefore " + name + "---");
    }

    @AfterReturning(pointcut = "anyMethod()", returning = "result")//声明后置通知
    public void doAfterReturning(String result) {
        System.out.println("后置通知");
        System.out.println("--- doAfterReturning " + result + "---");
    }

    @AfterThrowing(pointcut = "anyMethod()", throwing = "e")//声明例外通知
    public void doAfterThrowing(Exception e) {
        System.out.println(" doAfterThrowing 例外通知");
        System.out.println(e.getMessage());
    }

    @After("anyMethod()")//声明最终通知
    public void doAfter() {
        System.out.println("doAfter 最终通知");
    }

    @Around("anyMethod()")//声明环绕通知
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("doAround 进入方法---环绕通知");
        logger.info("doAround 进入方法---环绕通知");
        //显示调用，确保被代理的方法被调用
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }
}