package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.ArticleBean;

@Repository
public interface ArticleDao {
	// ��������
	public int addArticle(ArticleBean article);

	// ɾ������
	public int deleteArticle(@Param("articleId") int articleId);

	// �����������ࡢ���⡢����
	public int updateArticle(ArticleBean article);

	// ͨ������id��ѯ
	public ArticleBean getArticleById(@Param("articleId") int articleId);

	// ͨ�������ѯ
	public List<ArticleBean> getArticleByCategoryId(@Param("categoryId") int categoryId);

	// ͨ��������email��ѯ
	public List<ArticleBean> getArticleBySponsorEmail(@Param("email") String email);

}
