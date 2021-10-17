package com.bokchoy.nowcode_community;

import com.bokchoy.nowcode_community.dao.HibernateImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
//定义配置文件
@ContextConfiguration(classes = NowcodeCommunityApplication.class)
class NowcodeCommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		HibernateImpl hibernate = (HibernateImpl)applicationContext.getBean("Hibernate");
		System.out.println(hibernate);
	}
}
