package com.hjj.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.CommentBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-*.xml" })
// spring.xml
public class CommentServiceTest {

	@Autowired
	private CommentService commentService;

	@Test
	public void testAddComment() {
		CommentBean commentBean = new CommentBean();
		commentBean.setCommentArticleId(1);
		commentBean.setCommentByEmail("19689405@qq.com");
		commentBean.setCommentByName("HJJ");
		commentBean.setCommentContent("15465465");
		commentService.AddComment(commentBean);
	}

	@Test
	public void testGetCommentByArticleId() {
		commentService.getCommentByArticleId(5);
	}

}
