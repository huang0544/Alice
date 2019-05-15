package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.ArticleBean;

@Repository
public interface ArticleDao {
	// 发布文章
	public int addArticle(ArticleBean article);

	// 删除文章
	public int deleteArticle(@Param("articleId") int articleId);

	// 更新文章种类、标题、内容
	public int updateArticle(ArticleBean article);

	// 通过文章id查询
	public ArticleBean getArticleById(@Param("articleId") int articleId);

	// 通过种类查询
	public List<ArticleBean> getArticleByCategoryId(@Param("categoryId") int categoryId);

	// 通过发布人email查询
	public List<ArticleBean> getArticleBySponsorEmail(@Param("email") String email);

}
