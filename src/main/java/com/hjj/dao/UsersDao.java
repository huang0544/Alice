package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.UserBean;

@Repository
public interface UsersDao {
	//通过用户email获取用户信息
	public UserBean getUserByEmail(String email);
	//添加用户
	public int addUser(UserBean userBean);
	//删除用户
	public int deleteUser(@Param("email") String email);
	//更新用户信息
	public int updateUser(UserBean userBean);
	//更新用户密码
	public int updateUserPassword(@Param("email") String email,@Param("password") String password);
	//获取所有用户信息
	public List<UserBean> getAllUsers();
}
