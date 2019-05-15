package com.hjj.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.UserBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-*.xml" })
// spring.xml
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;

	@Test
	public void testGetUserByEmail() {
		usersService.getUserByEmail("11968940@qq.com");
	}

	@Test
	public void testAddUser() {
		UserBean userBean = new UserBean();
		userBean.setEmail("123456@qq.com");
		userBean.setIphone("15917934393");
		userBean.setName("hjj");
		userBean.setPassword("123456");
		userBean.setRoleid(0);
		userBean.setSex("ÄÐ");
		usersService.addUser(userBean);
	}

	@Test
	public void testUpdateUser() {
		UserBean userBean = new UserBean();
		userBean.setEmail("123456@qq.com");
		userBean.setIphone("15917934393");
		userBean.setName("hjj");
		userBean.setPassword("123456");
		userBean.setRoleid(0);
		userBean.setSex("ÄÐ");
		usersService.updateUser(userBean);
	}

	@Test
	public void testUpdateUserPassword() {
		usersService.updateUserPassword("19689405@qq.com", "123456");
	}

}
