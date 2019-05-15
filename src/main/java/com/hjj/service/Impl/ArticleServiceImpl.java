package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjj.dao.ArticleDao;
import com.hjj.pojo.ArticleBean;
import com.hjj.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Override
	public int addArticle(ArticleBean article) {
		return articleDao.addArticle(article);
	}

	@Override
	public int deleteArticle(int articleId) {
		return articleDao.deleteArticle(articleId);
	}

	@Override
	public int updateArticle(ArticleBean article) {
		return articleDao.updateArticle(article);
	}

	@Override
	public ArticleBean getArticleById(int articleId) {
		return articleDao.getArticleById(articleId);
	}

	@Override
	public List<ArticleBean> getArticleByCategoryId(int categoryId) {
		return articleDao.getArticleByCategoryId(categoryId);
	}

	@Override
	public List<ArticleBean> getArticleBySponsorEmail(String email) {
		return articleDao.getArticleBySponsorEmail(email);
	}


}
