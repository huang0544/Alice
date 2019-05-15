package com.hjj.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hjj.pojo.ArticleBean;

//spring����ע��bean�ļ�
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class ArticleDaoTest {
	@Autowired
	private ArticleDao articleDao;

	// ��������
	@Test
	public void addArticle() {
		ArticleBean articlebean = new ArticleBean();
		articlebean.setArticleCategoryName("����");
		articlebean.setArticleContent("65111111");
		articlebean.setArticleCategoryId(1);
		articlebean.setArticleName("HJJ");
		articlebean.setArticleSponsorEmail("19689405@qq.com");
		articlebean.setArticleSponsorName("Hjj");
		int result = articleDao.addArticle(articlebean);
		assertEquals(1, result);
	}

	// ɾ������
	@Test
	public void deleteArticle() {
		int result = articleDao.deleteArticle(2);
		assertEquals(1, result);
	}

	// �����������ࡢ���⡢����
	@Test
	public void updateArticle() {
		ArticleBean articlebean = new ArticleBean();
		articlebean.setArticleCategoryName("����");
		articlebean.setArticleContent("65111111");
		articlebean.setArticleCategoryId(1);
		articlebean.setArticleName("HJJ");
		articlebean.setArticleSponsorEmail("19689405@qq.com");
		articlebean.setArticleSponsorName("Hjj");
		articlebean.setArticleId(1);
		int result = articleDao.updateArticle(articlebean);
		assertEquals(1, result);
	}

	// ͨ������id��ѯ
	@Test
	public void getArticleById() {
		articleDao.getArticleById(4);
	}

	// ͨ�������ѯ
	@Test
	public void getArticleByCategoryId() {
		articleDao.getArticleByCategoryId(1);
	}

	// ͨ��������email��ѯ
	@Test
	public void getArticleBySponsorEmail() {
		articleDao.getArticleBySponsorEmail("196980450@qq.com");
	}

}
