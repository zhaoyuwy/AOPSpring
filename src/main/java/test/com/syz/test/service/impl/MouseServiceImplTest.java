package test.com.syz.test.service.impl; 

import com.syz.test.entity.Mouse;
import com.syz.test.service.MouseService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
* MouseServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ���� 13, 2016</pre> 
* @version 1.0 
*/

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class MouseServiceImplTest {

    @Resource(name = "mouseService")
    public MouseService mouseService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setDao(BaseDao<Mouse> dao) 
* 
*/

@Test
public void testSetDao() {
//TODO: Test goes here..

        Mouse mouse = new Mouse();
    mouse.setPassword("dddddd");
    mouse.setUsername("rrrrrr");
//		dog2.save(dog);
        mouseService.save(mouse);

} 


} 
