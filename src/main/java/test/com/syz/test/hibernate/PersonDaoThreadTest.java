package com.syz.test.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.syz.test.dao.PersonDao;
import com.syz.test.entity.Person;
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class PersonDaoThreadTest {

	@Resource(name = "PersonDaoImpl")

	/*
	 * @Autowired
	 * 
	 * @Qualifier("personDaoImpl") �����д��������һ��Ч��һ��
	 */
	// @Autowired
	public PersonDao personDao;

	// @Ignore
	@Test
	public void testWritePerson() throws InterruptedException {
		

		for (int i = 0; i < 3; i++) {
			Person person = new Person();
			person.setAge(2);
			person.setName(String.valueOf(i) +"a");
			personDao.save(person);
			Thread.sleep(1000);
		}
	}

	@Test
	public void testWritePerson2() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			Person person = new Person();
			person.setAge(3);
			person.setName(String.valueOf(i) +"b");
			personDao.save(person);
			Thread.sleep(5000);
		}
	}
	
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		System.out.println("----����ʼ����----");
		Date date1 = new Date();

		int taskSize = 5;
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// ��������з���ֵ������
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " ");
			// ִ�����񲢻�ȡFuture����
			Future f = pool.submit(c);
			// System.out.println(">>>" + f.get().toString());
			list.add(f);
		}
		// �ر��̳߳�
		pool.shutdown();

		// ��ȡ���в�����������н��
		for (Future f : list) {
			// ��Future�����ϻ�ȡ����ķ���ֵ�������������̨
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----�����������----����������ʱ�䡾" + (date2.getTime() - date1.getTime()) + "���롿");
	}

}


class MyCallable implements Callable<Object> {
	private String taskNum;
	
//	@Resource(name = "PersonDaoImpl")

	/*
	 * @Autowired
	 * 
	 * @Qualifier("personDaoImpl") �����д��������һ��Ч��һ��
	 */
	 @Autowired
	public PersonDao personDao;
	
	MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}

	public Object call() throws Exception {
		
		BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
//		PersonDaoImpl at = (PersonDaoImpl) bf.getBean("PersonDaoImpl");
		
//		Person person = new Person();
//		person.setAge(2);
//		person.setName(String.valueOf(222) +"a");
//		personDao.save(person);
		
		
		System.out.println(">>>" + taskNum + "��������");
		Date dateTmp1 = new Date();
//		testWritePerson();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "������ֹ");
		return taskNum + "���񷵻����н��,��ǰ����ʱ�䡾" + time + "���롿";
	}
}