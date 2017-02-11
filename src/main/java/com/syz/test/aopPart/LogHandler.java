package com.syz.test.aopPart;

/**
 * Created by Administrator on 2016/12/17.
 */
public class LogHandler {
    public void LogBefore()
    {
        System.out.println("Log before method");
    }

    public void LogAfter()
    {
        System.out.println("Log after method");
    }
}
