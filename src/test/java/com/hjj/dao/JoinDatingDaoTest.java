package com.hjj.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.JoinDatingBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class JoinDatingDaoTest {
	@Autowired
	private JoinDatingDao joinDatingDao;

	@Test
	public void testAddJoinDating() {
		JoinDatingBean joinDatingBean = new JoinDatingBean();
		joinDatingBean.setJoinDatingContent("1111233");
		joinDatingBean.setJoinDatingName("sadasd");
		joinDatingBean.setJoinDatingId(5);
		joinDatingBean.setJoinUserName("HJJ");
		joinDatingBean.setJoinDatingSponsorEmail("346484458@qq.com");
		joinDatingBean.setJoinDatingSponsorName("111");
		joinDatingBean.setJoinDatingStartTime("2018-02-25 21:03:05");
		joinDatingBean.setJoinDatingOverTime("2018-02-25 21:03:05");
		joinDatingBean.setJoinUserEmail("346484458@qq.com");
		joinDatingBean.setJoinUserIphone("15917934393");
		joinDatingBean.setJoinUserName("hjj");
		joinDatingBean.setJoinUserSex("nan");
		joinDatingDao.addJoinDating(joinDatingBean);
	}

	@Test
	public void testDeleteJoinDating() {
		joinDatingDao.deleteJoinDating(2);
	}

	@Test
	public void testGetJoinDatingByUserEamil() {
		joinDatingDao.getJoinDatingByUserEamil("346484458@qq.com");
	}

	@Test
	public void testGetJoinDatingByDatingId() {
		joinDatingDao.getJoinDatingByDatingId(0);
	}

}
