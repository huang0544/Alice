package com.hjj.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hjj.pojo.ArticleBean;

//spring加载注入bean文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class ArticleDaoTest {
	@Autowired
	private ArticleDao articleDao;

	// 发布文章
	@Test
	public void addArticle() {
		ArticleBean articlebean = new ArticleBean();
		articlebean.setArticleCategoryName("测试");
		articlebean.setArticleContent("65111111");
		articlebean.setArticleCategoryId(1);
		articlebean.setArticleName("HJJ");
		articlebean.setArticleSponsorEmail("19689405@qq.com");
		articlebean.setArticleSponsorName("Hjj");
		int result = articleDao.addArticle(articlebean);
		assertEquals(1, result);
	}

	// 删除文章
	@Test
	public void deleteArticle() {
		int result = articleDao.deleteArticle(2);
		assertEquals(1, result);
	}

	// 更新文章种类、标题、内容
	@Test
	public void updateArticle() {
		ArticleBean articlebean = new ArticleBean();
		articlebean.setArticleCategoryName("测试");
		articlebean.setArticleContent("65111111");
		articlebean.setArticleCategoryId(1);
		articlebean.setArticleName("HJJ");
		articlebean.setArticleSponsorEmail("19689405@qq.com");
		articlebean.setArticleSponsorName("Hjj");
		articlebean.setArticleId(1);
		int result = articleDao.updateArticle(articlebean);
		assertEquals(1, result);
	}

	// 通过文章id查询
	@Test
	public void getArticleById() {
		articleDao.getArticleById(4);
	}

	// 通过种类查询
	@Test
	public void getArticleByCategoryId() {
		articleDao.getArticleByCategoryId(1);
	}

	// 通过发布人email查询
	@Test
	public void getArticleBySponsorEmail() {
		articleDao.getArticleBySponsorEmail("196980450@qq.com");
	}

}
