package com.syz.test.aopAnotion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;


/**
 * Created by Administrator on 2016/12/17.
 */
@Order(1)
@Aspect
public class LogHandlerAop  {
    Logger logger = LoggerFactory.getLogger(LogHandlerAop.class);
    String strLog = null;

    @Pointcut("execution(* com.syz.test.business.*.*(..))")
    //声明一个切入点
    private void anyMethod() {

        System.out.println("我是anyMethod");
    }

    @Before("anyMethod() && args(name)")//声明前置通知
    public void doBefore(String name) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$LogHandlerAop doBefore");
    }

    @Around("anyMethod()")//声明环绕通知
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogHandlerAop doAround 进入方法---环绕通知5%%%%%%%%%%%%%%%%%");
        logger.info("LogHandlerAop doAround 进入方法---环绕通知5%%%%%%%%%%%%%%%%%");
        //显示调用，确保被代理的方法被调用
        Object o = pjp.proceed();
        logger.info("LogHandlerAop 退出方法---环绕通知%%%%%%%%%%%%%%%%%%%");
        return o;
    }

    @Before("anyMethod() && args(loge)")//声明前置通知
    public void doBefore2(Logger loge) {
        loge.info("$$$$$$$$$$$$$$$$$$$$$$LogHandlerAop doBefore2");
    }


}
