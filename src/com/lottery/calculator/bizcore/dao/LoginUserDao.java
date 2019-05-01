package com.lottery.calculator.bizcore.dao;

import java.util.Objects;

public class LoginUserDao {

	public boolean checkLogin(String userName, String password) {
		if (Objects.equals(userName, "arun") && Objects.equals(password, "passw0rd")) {
			return true;
		}
		return false;
	}

}
