package com.hjj.service.Impl;

import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjj.dao.UsersDao;
import com.hjj.service.PasswordService;
import com.hjj.util.SendEmail;

@Service
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public int SendPassword(String email) {
		int result = 1;
		String userInfo = usersDao.getUserByEmail(email).getPassword();
		System.out.println("√‹¬Î£∫" + "" + userInfo);
		SendEmail sendEmail = SendEmail.getInStance();
		if (email != null) {
			try {
				sendEmail.send(userInfo, email, 1);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = 0;
			}
		} else {
			result = 0;
		}
		return result;
	}

}
