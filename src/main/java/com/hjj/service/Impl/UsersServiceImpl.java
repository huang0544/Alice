package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjj.dao.UsersDao;
import com.hjj.pojo.UserBean;
import com.hjj.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;

	@Override
	public UserBean getUserByEmail(String email) {
		return usersDao.getUserByEmail(email);
	}

	@Override
	public int addUser(UserBean userBean) {
		return usersDao.addUser(userBean);
	}

	@Override
	public int deleteUser(String email) {
		return usersDao.deleteUser(email);
	}

	@Override
	public int updateUser(UserBean userBean) {
		return usersDao.updateUser(userBean);
	}

	@Override
	public int updateUserPassword(String email, String password) {
		return usersDao.updateUserPassword(email, password);
	}

	@Override
	public List<UserBean> getAllUsers() {
		return usersDao.getAllUsers();
	}

}
