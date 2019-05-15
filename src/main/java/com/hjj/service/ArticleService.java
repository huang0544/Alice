package com.hjj.service;

import java.util.List;


import com.hjj.pojo.ArticleBean;

public interface ArticleService {
	//��������
	public int addArticle(ArticleBean article);
	//ɾ������ 
	public int deleteArticle(int articleId);
	//�����������ࡢ���⡢����
	public int updateArticle(ArticleBean article);
	//ͨ������id��ѯ
	public ArticleBean getArticleById(int articleId);
	//ͨ�������ѯ
	public List<ArticleBean> getArticleByCategoryId(int categoryId);
	//ͨ��������email��ѯ
	public List<ArticleBean> getArticleBySponsorEmail(String email);
	
}
