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
import com.syz.test.entity.Dog;
import com.syz.test.service.CatService;
import com.syz.test.service.DogService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DaogSercivceImplReadTest {
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
		
		DogThread4 mTh1 = new DogThread4("dogname_1");
		DogThread4 mTh2 = new DogThread4("dogname_2");
		mTh1.start();
		mTh2.start();
		
//		while(true){
//			ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//			CatDao catdao = (CatDao) ac.getBean("catDao");
//			byte[] ar = new byte[1024*1024*5000];
//		}
		
	}
}

class DogThread4 extends Thread {
	private static Logger logger = LoggerFactory.getLogger(DogThread4.class);
	private String name;

	public DogThread4(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
				DogService dogdao = (DogService) ac.getBean("dogService");
				List<Dog>  dogList = dogdao.getAllList();
				
				if(dogList == null || dogList.size() ==0){
					continue;
				}
				System.out.println(dogList.size());
				for(int j = 0; j<dogList.size();j++ ){
					logger.info(dogList.get(j).getUsername() +" j = " + j +" i = "+ i );
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
