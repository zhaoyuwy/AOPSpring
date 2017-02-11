package com.syz.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.syz.test.entity.Cat;
import com.syz.test.service.CatService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class CatSercivceImplReadTest {
	@Resource(name = "catService")
	public CatService catService;

	@Test
	public void test() {
		// fail("Not yet implemented");
		Cat cat = new Cat();
//		catService.findById(cat);
	}

	@Test
	public void test3() {
	}

	public static void main(String[] args) {

//		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		CatDao dogService2 = (CatDao) ac.getBean("catDao");
//		System.out.println(dogService2.toString());
//		Cat dog = new Cat();
//		dog.setPassword("dddddd");
//		dog.setUsername("rrrrrr");
//		dogService2.save(dog);
		
		CatThread3 mTh1 = new CatThread3("catname_1");
		CatThread3 mTh2 = new CatThread3("catname_2");
		mTh1.start();
		mTh2.start();
		
//		while(true){
//			ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//			CatDao catdao = (CatDao) ac.getBean("catDao");
//			byte[] ar = new byte[1024*1024*5000];
//		}
		
	}
}

class CatThread3 extends Thread {
	private static Logger logger = LoggerFactory.getLogger(CatThread3.class);
	private String name;

	public CatThread3(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
				CatService catdao = (CatService) ac.getBean("catService");
				List<Cat>  catList = catdao.getAllList();
				
				if(catList == null || catList.size() ==0){
					continue;
				}
				System.out.println(catList.size());
				for(int j = 0; j<catList.size();j++ ){
					logger.info(catList.get(j).getUsername() +" j = " + j +" i = "+ i );
				}
//				catdao.save(cat);
//				Serializable id = new 
//				catdao.findById(id);
				if ("catname_1".endsWith(name)) {
					sleep((int) Math.random() * 10);
				}
			} catch (InterruptedException e) {
				logger.error(" save error ", e);
			}
		}

	}
}
