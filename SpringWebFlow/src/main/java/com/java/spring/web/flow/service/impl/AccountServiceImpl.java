package com.java.spring.web.flow.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.java.spring.web.flow.dao.AccountDao;
import com.java.spring.web.flow.enums.Role;
import com.java.spring.web.flow.model.Account;
import com.java.spring.web.flow.model.Account.StatusAccount;
import com.java.spring.web.flow.service.AccountService;

@Repository(AccountService.NAME)
public class AccountServiceImpl implements AccountService{

	@Autowired
	@Qualifier(value=AccountDao.NAME)
	private AccountDao accountDao;
	
	@Override
	public Account registerAcount(Account account) {
		account.setStatusAccount(StatusAccount.ENABLE);
		account.setRole(Role.ROLE_ADMIN);
		Account registeredAccount = accountDao.addNewAcount(account);
		return registeredAccount;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}
	
	public List<String> getRoles(Role role){
		List<String> roles = new ArrayList<>();
		roles.add(role.name());
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		Account acLogin = getUserByEmail(email);
		User user = new User(acLogin.getEmail(), acLogin.getPassword(), 
				true, true, true,true, getAuthorities(acLogin.getRole()));
		return user;
	}

	@Override
	public Account getUserByEmail(String email) {
		Account account = accountDao.getUserByEmail(email);
		return account;
	}
}
