package com.hjj.service;

import javax.servlet.http.HttpServletRequest;

import com.hjj.pojo.UserBean;

public interface LoginAndRegisterService {
	//µÇÂ¼
	public int Login(String email,String password,HttpServletRequest request);
	//×¢²áÉêÇë
	public int RegisterApply(UserBean usersBean);
	//×¢²áÈ·ÈÏ
	public int RegisterSure(HttpServletRequest request);
}
