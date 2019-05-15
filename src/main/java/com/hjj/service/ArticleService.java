package com.hjj.service;

import java.util.List;


import com.hjj.pojo.ArticleBean;

public interface ArticleService {
	//发布文章
	public int addArticle(ArticleBean article);
	//删除文章 
	public int deleteArticle(int articleId);
	//更新文章种类、标题、内容
	public int updateArticle(ArticleBean article);
	//通过文章id查询
	public ArticleBean getArticleById(int articleId);
	//通过种类查询
	public List<ArticleBean> getArticleByCategoryId(int categoryId);
	//通过发布人email查询
	public List<ArticleBean> getArticleBySponsorEmail(String email);
	
}
