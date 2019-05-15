package com.hjj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hjj.pojo.ArticleBean;
import com.hjj.pojo.DatingBean;

public interface SearchService {
	// 模糊查询文章
	List<ArticleBean> getSearchArticle(String articleName);

	// 模糊查询活动
	List<DatingBean> getSearchDating(String datingName);

}
