package com.hjj.service;

import javax.servlet.http.HttpServletRequest;

import com.hjj.pojo.UserBean;

public interface LoginAndRegisterService {
	//��¼
	public int Login(String email,String password,HttpServletRequest request);
	//ע������
	public int RegisterApply(UserBean usersBean);
	//ע��ȷ��
	public int RegisterSure(HttpServletRequest request);
}
