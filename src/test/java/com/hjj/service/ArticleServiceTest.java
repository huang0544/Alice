package com.hjj.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.ArticleBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-*.xml" })
// spring.xml
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@Test
	public void testAddArticle() {
		ArticleBean articleBean = new ArticleBean();
		articleBean.setArticleCategoryId(0);
		articleBean.setArticleCategoryName("GHH");
		articleBean.setArticleContent("sadsadas");
		articleBean.setArticleName("asda");
		articleBean.setArticleSponsorEmail("19689405@qq.com");
		articleBean.setArticleSponsorName("HJJ");
		articleService.addArticle(articleBean);
	}

	@Test
	public void testDeleteArticle() {
		articleService.deleteArticle(1);
	}

	@Test
	public void testUpdateArticle() {
		ArticleBean articleBean = new ArticleBean();
		articleBean.setArticleCategoryId(0);
		articleBean.setArticleCategoryName("GHH");
		articleBean.setArticleContent("sadsadas");
		articleBean.setArticleName("asda");
		articleBean.setArticleSponsorEmail("19689405@qq.com");
		articleBean.setArticleSponsorName("HJJ");
		articleBean.setArticleId(0);
		articleService.updateArticle(articleBean);
	}

	@Test
	public void testGetArticleById() {
		articleService.getArticleById(1);
	}

	@Test
	public void testGetArticleByCategoryId() {
		articleService.getArticleByCategoryId(0);
	}

	@Test
	public void testGetArticleBySponsorEmail() {
		articleService.getArticleBySponsorEmail("1968940522qq.com");
	}

}
