package com.bokchoy.nowcode_community;

import com.bokchoy.nowcode_community.entity.User;
import com.bokchoy.nowcode_community.entity.UserExample;
import com.bokchoy.nowcode_community.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
//定义配置文件
@ContextConfiguration(classes = NowcodeCommunityApplication.class)
//@MapperScan(basePackages = "com.bokchoy.nowcode_community.mapper")
class NowcodeCommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
	}
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testMybatis(){
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(1);
		List<User> users = userMapper.selectByExample(example);
		System.out.println(users.get(0));
	}
}
