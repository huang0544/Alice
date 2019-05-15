package com.hjj.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hjj.pojo.CategoryBean;
import com.hjj.service.CategoryService;

@Controller
public class CategoryControll {
	@Autowired
	CategoryService categoryService;
	
	//��Ӱ��ӿ�
	@RequestMapping("AddCategory")
	@ResponseBody
	public int addCategory(@RequestBody CategoryBean category){
		int result=categoryService.addCategory(category);
		return result;
	}
	
	//ɾ�����ӿ�
	@RequestMapping("DeleteCategory")
	@ResponseBody
	public int deleteCategory(@RequestBody int categoryId){
		int result=categoryService.deleteCategory(categoryId);
		return result;
	}
	
	//���°�����
	@RequestMapping("UpdateCategory")
	@ResponseBody
	public int updateCategory(@RequestBody int categoryId,String categoryName){
		int result=categoryService.updateCategory(categoryId, categoryName);
		return result;
	}
	

}
