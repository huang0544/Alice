package com.hjj.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.UserBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class UsersDaoTest {
	@Autowired
	private UsersDao usersDao;

	@Test
	public void testGetUserByEmail() {
		UserBean userBean=usersDao.getUserByEmail("19689405@qq.com");
	}

	@Test
	public void testAddUser() {
		UserBean userbean = new UserBean();
		userbean.setEmail("123456@qq.com");
		userbean.setIphone("15917934393");
		userbean.setName("hjj");
		userbean.setPassword("123456");
		userbean.setRoleid(0);
		userbean.setSex("ÄÐ");
		usersDao.addUser(userbean);
	}

	@Test
	public void testUpdateUser() {
		UserBean userbean = new UserBean();
		userbean.setEmail("19689405@qq.com");
		userbean.setIphone("15917934393");
		userbean.setName("hjj");
		userbean.setPassword("123456");
		userbean.setRoleid(0);
		userbean.setSex("ÄÐ");
		usersDao.updateUser(userbean);
	}

	@Test
	public void testUpdateUserPassword() {
		usersDao.updateUserPassword("19689405@qq.com", "123456");
	}

}
