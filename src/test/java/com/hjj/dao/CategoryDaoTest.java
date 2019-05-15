package com.hjj.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hjj.pojo.CategoryBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-dao.xml" })
// spring.xml
public class CategoryDaoTest {
	@Autowired
	private CategoryDao cateoryDao;

	@Test
	public void testAddCategory() {
		CategoryBean category = new CategoryBean();
		category.setCategoryIntroduce("Ëæ±ãÀ²");
		category.setCategoryName("HJJ");
		int result = cateoryDao.addCategory(category);
		assertEquals(result, 1);
	}

	@Test
	public void testDeleteCategory() {
		int result = cateoryDao.deleteCategory(1);
		assertEquals(result, 1);
	}

	@Test
	public void testGetAllCatetory() {
		List<CategoryBean> result = cateoryDao.getAllCatetory();
		assertNotNull(result);
	}

	@Test
	public void testUpdateCategory() {
		int result = cateoryDao.updateCategory(1, "HJJ");
		assertEquals(result, 1);
	}

}
