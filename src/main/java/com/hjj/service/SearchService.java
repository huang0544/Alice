package com.hjj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hjj.pojo.ArticleBean;
import com.hjj.pojo.DatingBean;

public interface SearchService {
	// ģ����ѯ����
	List<ArticleBean> getSearchArticle(String articleName);

	// ģ����ѯ�
	List<DatingBean> getSearchDating(String datingName);

}
