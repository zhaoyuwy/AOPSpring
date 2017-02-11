package com.cg;


import java.io.IOException;
import java.util.Timer;

/*
 * ���������ʹ��Timer��TimerTaske����Ҫ����,���а�����������,�������
 * �˳�����,�˳���ʱ��.
 * ��ΪTimerTask��status���ǰ����ɷ��ʵ�,����û�а취��java.util.����
 * �õ���״̬,��Ա�����һЩ���� .���ǲ����ж�ĳ��Task��״̬��.
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
                // ͨ��ʹ��ָ�����ַ�������ָ���� byte �����飬����һ���µ� String��
                String strInfo = new String(info, 0, len, "GBK");//�ӿ���̨������Ϣ
                if (strInfo.charAt(strInfo.length() - 1) == ' ') {
                    strInfo = strInfo.substring(0, strInfo.length() - 2);
//                    System.out.println(strInfo+"1");
                }
                if (strInfo.startsWith("Cancel-1")) {
                    myTask1.cancel();//�˳���������
                    // ��ʵӦ���������ж�myTask2�Ƿ�Ҳ�˳���,�ǵĻ���Ӧ��break.������Ϊ�޷��ڰ���õ�
                    // myTask2��״̬,����,���ﲻ�������Ƿ��˳�ѭ�����ж�.
                } else if (strInfo.startsWith("Cancel-2")) {
                    myTask2.cancel();
                } else if (strInfo.startsWith("Cancel-All")) {
                    timer.cancel();//�˳�Timer
                    break;
                } else {
                    // ֻ��myTask1�����ж�,͵����^_^
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

