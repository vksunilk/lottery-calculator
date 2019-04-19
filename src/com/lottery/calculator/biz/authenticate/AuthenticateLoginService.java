package com.lottery.calculator.biz.authenticate;

import com.lottery.calculator.bizcore.dao.LoginUserDao;

public class AuthenticateLoginService {

	private LoginUserDao loginUserDao;

	public AuthenticateLoginService() {
		loginUserDao = new LoginUserDao();
	}

	public boolean authenticate(String userName, char[] passwordChar) {
		String passwordStr = new String(passwordChar);
return true;
//		return loginUserDao.checkLogin(passwordStr, passwordStr);
	}

}
