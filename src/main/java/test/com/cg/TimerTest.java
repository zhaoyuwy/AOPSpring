package com.cg;


import java.io.IOException;
import java.util.Timer;

/*
 * 本类给出了使用Timer和TimerTaske的主要方法,其中包括定制任务,添加任务
 * 退出任务,退出定时器.
 * 因为TimerTask的status域是包级可访问的,所以没有办法在java.util.包外
 * 得到其状态,这对编程造成一些不便 .我们不能判断某个Task的状态了.
 * @author www.zuidaima.com
 */
public class TimerTest {
	public static void main(String[] args) {
        Timer timer = new Timer();
        MyTask myTask1 = new MyTask();
        MyTask myTask2 = new MyTask();
        myTask2.setInfo("myTask-2");
        timer.schedule(myTask1, 1000, 2000);
        timer.scheduleAtFixedRate(myTask2, 2000, 3000);
        while (true) {
            try {
                byte[] info = new byte[1024];
                int len = System.in.read(info);
                // 通过使用指定的字符集解码指定的 byte 子数组，构造一个新的 String。
                String strInfo = new String(info, 0, len, "GBK");//从控制台读出信息
                if (strInfo.charAt(strInfo.length() - 1) == ' ') {
                    strInfo = strInfo.substring(0, strInfo.length() - 2);
//                    System.out.println(strInfo+"1");
                }
                if (strInfo.startsWith("Cancel-1")) {
                    myTask1.cancel();//退出单个任务
                    // 其实应该在这里判断myTask2是否也退出了,是的话就应该break.但是因为无法在包外得到
                    // myTask2的状态,所以,这里不能做出是否退出循环的判断.
                } else if (strInfo.startsWith("Cancel-2")) {
                    myTask2.cancel();
                } else if (strInfo.startsWith("Cancel-All")) {
                    timer.cancel();//退出Timer
                    break;
                } else {
                    // 只对myTask1作出判断,偷个懒^_^
                    myTask1.setInfo(strInfo);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
	 static class MyTask extends java.util.TimerTask {
	        String info = "^_^";

	        @Override
	        public void run() {
	            // TODO Auto-generated method stub
	            System.out.println(info);
	        }

	        public String getInfo() {
	            return info;
	        }

	        public void setInfo(String info) {
	            this.info = info;
	        }

	    }

	}

