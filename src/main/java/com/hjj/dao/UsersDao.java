package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.UserBean;

@Repository
public interface UsersDao {
	//ͨ���û�email��ȡ�û���Ϣ
	public UserBean getUserByEmail(String email);
	//����û�
	public int addUser(UserBean userBean);
	//ɾ���û�
	public int deleteUser(@Param("email") String email);
	//�����û���Ϣ
	public int updateUser(UserBean userBean);
	//�����û�����
	public int updateUserPassword(@Param("email") String email,@Param("password") String password);
	//��ȡ�����û���Ϣ
	public List<UserBean> getAllUsers();
}
