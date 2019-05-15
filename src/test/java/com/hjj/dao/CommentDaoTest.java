package com.hjj.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.CommentBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class CommentDaoTest {
	@Autowired
	private CommentDao commentDao;

	@Test
	public void testAddComment() {
		CommentBean comment = new CommentBean();
		comment.setCommentArticleId(1);
		comment.setCommentByEmail("111651@qq.com");
		comment.setCommentByName("111");
		comment.setCommentContent("222");
		int result = commentDao.AddComment(comment);
		assertEquals(result, 1);
	}

	@Test
	public void testGetCommentByArticleId() {
		commentDao.getCommentByArticleId(1);
	}

}
