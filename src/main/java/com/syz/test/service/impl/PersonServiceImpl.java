package com.syz.test.service.impl;

import com.syz.test.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/17.
 */
@Service(value = "personService")
public class PersonServiceImpl implements PersonService {


    public String getPersonName() {
        System.out.println("我是getPersonName()方法。。。");
        return "返回结果";
    }


    public void save(String name) {
        System.out.println("我是save()方法。。。");
    }


    public void update(int name) {
        System.out.println("我是update()方法。。。");
    }


    public void throwException() {
        System.out.println("我是throwException()方法。。。");
        throw new RuntimeException("异常了。。");
    }
}