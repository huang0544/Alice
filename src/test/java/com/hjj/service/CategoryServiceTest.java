package com.hjj.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjj.pojo.CategoryBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-*.xml" })
// spring.xml
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;

	@Test
	public void testAddCategory() {
		CategoryBean categoryBean = new CategoryBean();
		categoryBean.setCategoryIntroduce("ssss");
		categoryBean.setCategoryName("HJJ");
		categoryService.addCategory(categoryBean);
	}

	@Test
	public void testDeleteCategory() {
		categoryService.deleteCategory(0);
	}

	@Test
	public void testGetAllCatetory() {
		categoryService.getAllCatetory();
	}

	@Test
	public void testUpdateCategory() {
		categoryService.updateCategory(0, "hahah");
	}

}
