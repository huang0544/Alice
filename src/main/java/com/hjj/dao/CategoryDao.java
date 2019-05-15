package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.CategoryBean;
@Repository
public interface CategoryDao {
	//Ìí¼Ó°å¿é
	public int addCategory(CategoryBean category);
	//É¾³ý°å¿é
	public int deleteCategory(int categoryId);
	//²éÑ¯°å¿é
	public List<CategoryBean> getAllCatetory();
	//¸üÐÂ°å¿é½éÉÜ
	public int updateCategory(@Param("categoryId") int categoryId,@Param("categoryName") String categoryName);
}
