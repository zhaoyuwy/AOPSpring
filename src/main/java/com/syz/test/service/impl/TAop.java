package com.syz.test.service.impl;

import com.syz.test.service.TAopService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/17.
 */
@Service(value ="tAop")
public class TAop implements TAopService {
   public void tAopLog4j(){
       System.out.println("###########TAop tAopLog4j dddd");
   }
}
