package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hjj.pojo.ArticleBean;
import com.hjj.pojo.DatingBean;

public interface SearchDao {
	//ģ����ѯ����
	List<ArticleBean> getSearchArticle(@Param("articleName") String articleName);
	//ģ����ѯ�
	List<DatingBean> getSearchDating(@Param("datingName") String datingName);
}
