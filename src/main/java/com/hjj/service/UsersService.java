package com.hjj.service;

import java.util.List;

import com.hjj.pojo.UserBean;


public interface UsersService {
	//ͨ���û�email��ȡ�û���Ϣ
	public UserBean getUserByEmail(String email);
	//����û�
	public int  addUser(UserBean userBean);
	//ɾ���û�
	public int deleteUser(String email);
	//�����û���Ϣ
	public int updateUser(UserBean userBean);
	//�����û�����
	public int updateUserPassword(String email,String password);
	//��ȡ�����û���Ϣ
	public List<UserBean> getAllUsers();
}
