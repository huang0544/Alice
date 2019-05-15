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
public class LoginAndRegisterServiceTest {

	@Autowired
	private LoginAndRegisterService loginAndRegisterService;

	// @Test
	// public void testLogin() {
	// loginAndRegisterService.Login("19689405@qq.com", "123456");
	// }

	@Test
	public void testRegisterApply() {
		UserBean userBean = new UserBean();
		userBean.setEmail("196840115@qq.com");
		userBean.setIphone("15917934393");
		userBean.setName("hjj");
		userBean.setPassword("123456");
		userBean.setRoleid(0);
		userBean.setSex("ÄÐ");
		loginAndRegisterService.RegisterApply(userBean);
	}

	// @Test
	// public void testRegisterSure() {
	// loginAndRegisterService.RegisterSure("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoie1wiZW1haWxcIjpcIjM0NjQ4NDQ1OEBxcS5jb21cIixcImlwaG9uZVwiOlwiMTk2ODk0MDVAcXEuY29tXCIsXCJuYW1lXCI6XCJoampcIixcInBhc3N3b3JkXCI6XCIxMjM0NTZcIixcInJvbGVpZFwiOjAsXCJzZXhcIjpcIueUt1wifSIsImlzcyI6ImF1dGgwIiwiZXhwIjoxNTE5ODMxODcyfQ.abzUL5kCzR8RDTE5eyRUhXsM-dvuWF__qzfrpz5oqk4");
	// }

}
