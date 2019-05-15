package com.hjj.service;

import java.util.List;

import com.hjj.pojo.CategoryBean;

public interface CategoryService {
	//Ìí¼Ó°å¿é
	public int addCategory(CategoryBean category);
	//É¾³ı°å¿é
	public int deleteCategory(int categoryId);
	//²éÑ¯°å¿é
	public List<CategoryBean> getAllCatetory();
	//¸üĞÂ°å¿é½éÉÜ
	public int updateCategory(int categoryId,String categoryName);
}
