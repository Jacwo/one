package com.yyl.one.event;

import com.yyl.one.OneApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/17 14:50
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OneApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStart {
	@Autowired
	TestPublish testPublish;
	@Test
	public void test(){
		TestParam testParam=new TestParam();
		testParam.setEmail("8989899");
		TestEvent testEvent=new TestEvent(testParam);
		testPublish.publishEvent(testEvent);
		System.out.println("我是main方法");

	}

}
