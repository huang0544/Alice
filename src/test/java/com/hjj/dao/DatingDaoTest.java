package com.hjj.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.DatingBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class DatingDaoTest {
	@Autowired
	private DatingDao datingDao;

	@Test
	public void testAddDating() {
		DatingBean dating = new DatingBean();
		dating.setDatingContent("�����");
		dating.setDatingName("jjj");
		// ��ʽ 24Сʱ��
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH��ʾ24Сʱ
		Date date = new Date();
		String formatDate = dFormat.format(date);
		dating.setDatingStartTime(formatDate);
		dating.setDatingOverTime(formatDate);
		dating.setDatingSponsorEmail("hjj@qq.com");
		dating.setDatingSponsorName("hjj");
		dating.setDatingSumpeople(5);
		int result = datingDao.AddDating(dating);
		assertEquals(result, 1);
	}

	@Test
	public void testDeleteDating() {
		datingDao.DeleteDating(2);
	}

	@Test
	public void testUpdateDating() {
		DatingBean dating = new DatingBean();
		dating.setDatingContent("�����");
		dating.setDatingName("jjj");
		// ��ʽ 24Сʱ��
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH��ʾ24Сʱ
		Date date = new Date();
		String formatDate = dFormat.format(date);
		dating.setDatingStartTime(formatDate);
		dating.setDatingOverTime(formatDate);
		dating.setDatingSponsorEmail("hjj@qq.com");
		dating.setDatingSponsorName("hjj");
		dating.setDatingSumpeople(5);
		int result = datingDao.UpdateDating(dating);
		assertEquals(result, 1);
	}

	@Test
	public void testGetDatingBySponsorEmail() {
		datingDao.GetDatingBySponsorEmail("hjj@qq.com");
	}

	@Test
	public void testGetDatingByDatingId() {
		datingDao.GetDatingByDatingId(1);
	}

}
