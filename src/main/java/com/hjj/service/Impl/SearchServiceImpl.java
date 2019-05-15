package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjj.dao.ArticleDao;
import com.hjj.dao.SearchDao;
import com.hjj.pojo.ArticleBean;
import com.hjj.pojo.DatingBean;
import com.hjj.service.SearchService;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public List<ArticleBean> getSearchArticle(String articleName) {
		return searchDao.getSearchArticle(articleName);
	}

	@Override
	public List<DatingBean> getSearchDating(String datingName) {
		return searchDao.getSearchDating(datingName);
	}

}
