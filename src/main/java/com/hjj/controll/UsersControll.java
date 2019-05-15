package com.hjj.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hjj.pojo.UserBean;
import com.hjj.service.CategoryService;
import com.hjj.service.UsersService;

@Controller
public class UsersControll {
	@Autowired
	private UsersService usersService;
	@Autowired
	private CategoryService categoryService;
	
	//通过用户email获取用户信息
	@RequestMapping("GetUserByEmail")
	@ResponseBody
	public UserBean getUserByEmail(@RequestBody String email){
		UserBean result=usersService.getUserByEmail(email);
		return result;
	}
	
	//添加用户
	@RequestMapping("AddUser")
	@ResponseBody
	public int addUser(@RequestBody UserBean userBean){
		int result=usersService.addUser(userBean);
		return result;
	}
	
	//删除用户
	@RequestMapping("DeleteUser")
	@ResponseBody
	public int DeleteUser(@RequestBody String data){
		String email = JSONObject.parseObject(data).getString("email");
		int result=usersService.deleteUser(email);
		return result;
	}
	//更新用户信息
	@RequestMapping("UpdateUser")
	@ResponseBody
	public int updateUser(@RequestBody UserBean userBean,HttpServletRequest request){
		HttpSession session=request.getSession();
		userBean.setEmail((session.getAttribute("userEmail").toString()));
        int result=usersService.updateUser(userBean);
		return result;
	}
	
	//更新用户密码
	@RequestMapping("UpdateUserPassword")
	@ResponseBody
	public int updateUserPassword(@RequestBody UserBean userBean){
		System.out.println(userBean.toString());
        int result=usersService.updateUserPassword(userBean.getEmail(), userBean.getPassword());
		return result;
	}
	
	//个人信息页面
	@RequestMapping("UserView")
	public ModelAndView UserView(HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView model=new ModelAndView("common/Users");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("User", usersService.getUserByEmail(session.getAttribute("userEmail").toString()));
		return model;
	}
	
	//个人信息编辑页面
	@RequestMapping("UserEditView")
	public ModelAndView UserEditView(HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView model=new ModelAndView("common/UserEdit");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("UserEdit",usersService.getUserByEmail(session.getAttribute("userEmail").toString()));
		return model;
	}
	
	//密码修改页面
	@RequestMapping("UpdatePassword")
	public ModelAndView UpdatePassword(HttpServletRequest request){
		HttpSession session=request.getSession();
		ModelAndView model=new ModelAndView("common/UpdatePassword");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("UserEdit",usersService.getUserByEmail(session.getAttribute("userEmail").toString()));
		return model;
	
	}
	
	
	
}
