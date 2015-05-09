package com.java.spring.web.flow.dao;

import com.java.spring.web.flow.model.Account;

public interface AccountDao{
	public static final String NAME = "accountDao";
	Account addNewAcount(Account acount);
	Account getUserByEmail(String email);
}
