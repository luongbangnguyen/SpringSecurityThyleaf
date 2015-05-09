package com.java.spring.web.flow.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.java.spring.web.flow.model.Account;

public interface AccountService extends UserDetailsService{
	public final String NAME = "accountService";
	Account registerAcount(Account acount);
	Account getUserByEmail(String email);
}
