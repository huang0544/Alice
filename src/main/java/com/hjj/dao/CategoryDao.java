package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.CategoryBean;
@Repository
public interface CategoryDao {
	//��Ӱ��
	public int addCategory(CategoryBean category);
	//ɾ�����
	public int deleteCategory(int categoryId);
	//��ѯ���
	public List<CategoryBean> getAllCatetory();
	//���°�����
	public int updateCategory(@Param("categoryId") int categoryId,@Param("categoryName") String categoryName);
}
