package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjj.dao.CategoryDao;
import com.hjj.pojo.CategoryBean;
import com.hjj.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public int addCategory(CategoryBean category) {
		return categoryDao.addCategory(category);
	}

	@Override
	public int deleteCategory(int categoryId) {
		return categoryDao.deleteCategory(categoryId);
	}

	@Override
	public List<CategoryBean> getAllCatetory() {
		return categoryDao.getAllCatetory();
	}

	@Override
	public int updateCategory(int categoryId, String categoryName) {
		return categoryDao.updateCategory(categoryId, categoryName);
	}

}
