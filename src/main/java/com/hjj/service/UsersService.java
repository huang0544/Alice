package com.hjj.service;

import java.util.List;

import com.hjj.pojo.UserBean;


public interface UsersService {
	//通过用户email获取用户信息
	public UserBean getUserByEmail(String email);
	//添加用户
	public int  addUser(UserBean userBean);
	//删除用户
	public int deleteUser(String email);
	//更新用户信息
	public int updateUser(UserBean userBean);
	//更新用户密码
	public int updateUserPassword(String email,String password);
	//获取所有用户信息
	public List<UserBean> getAllUsers();
}
