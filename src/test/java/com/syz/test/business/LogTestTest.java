package com.syz.test.business;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/17.
 */
public class LogTestTest {
    @Test
    public void test1 (){

        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        LogTest myAopLog4j = (LogTest) cxt.getBean("logTest");
//        LogTest myAopLog4j = new LogTest();
        myAopLog4j.fistMyAopLog4j();
    }

}