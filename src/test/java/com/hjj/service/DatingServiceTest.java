package com.hjj.service;

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
@ContextConfiguration(locations = { "classpath*:ApplicationContext-*.xml" })
// spring.xml
public class DatingServiceTest {

	@Autowired
	private DatingService datingService;

	@Test
	public void testAddDating() {
		DatingBean datingBean = new DatingBean();
		datingBean.setDatingContent("随便啦");
		datingBean.setDatingName("jjj");
		// 格式 24小时制
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH表示24小时
		Date date = new Date();
		String formatDate = dFormat.format(date);
		datingBean.setDatingStartTime(formatDate);
		datingBean.setDatingOverTime(formatDate);
		datingBean.setDatingSponsorEmail("hjj@qq.com");
		datingBean.setDatingSponsorName("hjj");
		datingBean.setDatingSumpeople(5);
		datingService.AddDating(datingBean);
	}

	@Test
	public void testDeleteDating() {
		datingService.DeleteDating(0);
	}

	@Test
	public void testUpdateDating() {
		DatingBean datingBean = new DatingBean();
		datingBean.setDatingContent("随便啦");
		datingBean.setDatingName("jjj");
		// 格式 24小时制
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH表示24小时
		Date date = new Date();
		String formatDate = dFormat.format(date);
		datingBean.setDatingStartTime(formatDate);
		datingBean.setDatingOverTime(formatDate);
		datingBean.setDatingSponsorEmail("hjj@qq.com");
		datingBean.setDatingSponsorName("hjj");
		datingBean.setDatingSumpeople(5);
		datingService.UpdateDating(datingBean);
	}

	@Test
	public void testGetDatingBySponsorEmail() {
		datingService.GetDatingBySponsorEmail("19689405@qq.com");
	}

	@Test
	public void testGetDatingByDatingId() {
		datingService.GetDatingByDatingId(0);
	}

}
