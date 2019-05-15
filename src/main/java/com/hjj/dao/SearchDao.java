package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hjj.pojo.ArticleBean;
import com.hjj.pojo.DatingBean;

public interface SearchDao {
	//模糊查询文章
	List<ArticleBean> getSearchArticle(@Param("articleName") String articleName);
	//模糊查询活动
	List<DatingBean> getSearchDating(@Param("datingName") String datingName);
}
