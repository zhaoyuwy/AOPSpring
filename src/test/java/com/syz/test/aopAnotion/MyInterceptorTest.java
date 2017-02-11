package com.syz.test.aopAnotion;

import com.syz.test.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/17.
 */
public class MyInterceptorTest {
        public static void main(String[] args) {
            ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
            PersonService personService = (PersonService) cxt.getBean("personService");

           /* System.out.println("----------------save start------------");
            personService.save("我是参数");
            System.out.println("----------------save end------------");


            System.out.println("----------------update start------------");
            personService.update(100);
            System.out.println("----------------update end------------");


//            System.out.println("----------------throwException start------------");
//            personService.throwException();
//            System.out.println("----------------throwException end------------");


            System.out.println("----------------getPersonName start------------");
            String result = personService.getPersonName();
            System.out.println(result);
            System.out.println("----------------getPersonName end------------");*/
        }
    }