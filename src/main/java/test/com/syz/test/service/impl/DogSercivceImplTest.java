package test.com.syz.test.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.syz.test.dao.DogDao;
import com.syz.test.entity.Dog;
import com.syz.test.service.DogService;
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DogSercivceImplTest {
	
	@Resource(name = "dogService")
	public DogService dogService;

	@Resource(name = "dogDao")
	public DogDao dog2;
	@Test
	public void test() {
		// fail("Not yet implemented");
		Dog dog = new Dog();
		dog.setPassword("dddddd");
		dog.setUsername("rrrrrr");
//		dog2.save(dog);
		dogService.save(dog);
	}

	public static void main(String[] args) {

//		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		DogDao dogService2 = (DogDao) ac.getBean("dogDao");
//		Dog dog = new Dog();
//		dog.setPassword("dddddd");
//		dog.setUsername("rrrrrr");
//		dogService2.save(dog);
//		DogThread mTh1 = new DogThread("dogname_1");
		DogThread mTh2 = new DogThread("dogname_2");
//		mTh1.start();
		mTh2.start();
	}

}


class DogThread extends Thread {
	private static Logger logger = LoggerFactory.getLogger(DogThread.class);
	private String name;

	public DogThread(String name) {
		this.name = name;
	}

	public void run() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		DogDao dogdao = null;
		for (int i = 0; i < 3; i++) {
			try {
				dogdao = (DogDao) ac.getBean("dogDao");
				Dog dog = new Dog();
				dog.setPassword(String.valueOf(i));
				dog.setUsername(name);
				logger.info("insert  " + name+"  " + i);
				dogdao.save(dog);
				if ("dogname_1".endsWith(name)) {
					logger.info(name +"  "+ i);
					sleep((int) Math.random() * 10);
				}else{
					logger.info(name +"  "+ i);
				}
			} catch (Exception e) {
				logger.error(" save error ", e);
			}
		}
		logger.info(name+ "  end");

	}
}

