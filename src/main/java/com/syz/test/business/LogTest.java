package com.syz.test.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.com.syz.test.hibernate.PersonDaoClearTest;

/**
 * Created by Administrator on 2016/12/17.
 */
public class LogTest {
    private Logger logger = LoggerFactory.getLogger(PersonDaoClearTest.class);

    public void fistMyAopLog4j(){
//        logger.info("###########LogTest fistMyAopLog4j ceshi");
        fistMyAopLog4j2(logger);

    }
    public void fistMyAopLog4j2(Logger logger){
        logger.info("###########LogTest fistMyAopLog4jddd ceshi");

    }
}
