package com.hjj.service;

import java.util.List;

import com.hjj.pojo.CategoryBean;

public interface CategoryService {
	//��Ӱ��
	public int addCategory(CategoryBean category);
	//ɾ�����
	public int deleteCategory(int categoryId);
	//��ѯ���
	public List<CategoryBean> getAllCatetory();
	//���°�����
	public int updateCategory(int categoryId,String categoryName);
}
