package com.syz.test.service.impl;

import com.syz.test.service.PersonService;
import com.syz.test.service.TAopService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/17.
 */
public class TAopTest {
    @Ignore
    @Test
    public void testTAOp() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        TAop tAop2 = (TAop) ac.getBean("tAop");
        TAop tAop = new TAop();
//        TAop tAop = new TAop();
        tAop2.tAopLog4j();
        tAop.tAopLog4j();
    }

    @Ignore
    @Test
    public void testTmyPerson() {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) cxt.getBean("personService");
        TAop tAop2 = (TAop) cxt.getBean("tAop");
        System.out.println("----------------save start------------");
        personService.save("我是参数");
        System.out.println("----------------save end------------");


        System.out.println("----------------update start------------");
        personService.update(100);
        System.out.println("----------------update end------------");


    }
//    @Ignore
    @Test
    public void testTAopsss() {

        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        TAopService tAop2 = (TAopService) cxt.getBean("tAop");

        System.out.println("###");
        System.out.println("###");
        System.out.println("###");
        System.out.println("###");

        System.out.println("----------------tAop start------------");
        tAop2.tAopLog4j();
        System.out.println("----------------tAop end------------");
    }
    @Test
    public void testCalss(){
        TAopService tAop222= new TAop();
        tAop222.tAopLog4j();
    }
}