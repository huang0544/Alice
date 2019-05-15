package com.hjj.service.Impl;

import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hjj.dao.UsersDao;
import com.hjj.pojo.UserBean;
import com.hjj.service.LoginAndRegisterService;
import com.hjj.util.SendEmail;
import com.hjj.util.TokenUtil;

@Service
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public int Login(String email, String password, HttpServletRequest request) {
		UserBean userBean = usersDao.getUserByEmail(email);
		if (userBean != null && userBean.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userBean.getName());
			session.setAttribute("userEmail", userBean.getEmail());
			session.setAttribute("iphone", userBean.getIphone());
			session.setAttribute("sex", userBean.getSex());
			session.setAttribute("password", userBean.getPassword());
			session.setAttribute("roleid", userBean.getRoleid());
			return 1;
		}
		return 0;
	}

	@Override
	public int RegisterApply(UserBean userBean) {
		System.out.println(userBean.toString());
		// ��ȡtoken������
		TokenUtil tokenUtil = TokenUtil.getInstance();
		// ��ȡ�����ʼ���
		SendEmail sendEmail = SendEmail.getInStance();
		// ���ܺ���û���Ϣ��JSON��ʽ
		String userInfo = tokenUtil.CreateTokenTime(JSONObject.toJSONString(userBean));
		System.out.println(userInfo);
		int result = 0;
		try {
			result = sendEmail.send(userInfo, userBean.getEmail(), 0);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int RegisterSure(HttpServletRequest request) {
		String userInfo = request.getParameter("email");
		// ��ȡtoken������
		TokenUtil tokenUtil = TokenUtil.getInstance();
		// �����ж�
		String jsonUserInfo = tokenUtil.Vertify(userInfo, 300);
		// jsonת����bean
		UserBean userBean = JSONObject.parseObject(jsonUserInfo, UserBean.class);
		System.out.println(userBean);
		int result = usersDao.addUser(userBean);
		if (result == 1) {
			return 1;
		}
		return 0;
	}

}
