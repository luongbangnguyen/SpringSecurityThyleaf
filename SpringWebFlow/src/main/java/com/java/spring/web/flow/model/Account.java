package com.java.spring.web.flow.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.java.spring.web.flow.enums.Role;

@Entity
@Table(name="account")
public class Account extends Model{
	
	public enum StatusAccount{ENABLE,DIASBLE,DELETE}
	
	@NotNull
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String userName;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
	private String email;
	
	@NotNull
	@Size(min=6, max=20,message="The password must be at least 6 characters long.")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private StatusAccount statusAccount;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Account() {}
	
	public Account(String userName, String email, String password,
			StatusAccount statusAccount) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.statusAccount = statusAccount;
	}
	
	public Account(Account account){
		this(account.userName,account.email,account.password, account.statusAccount);
	}
	
	/**
	 * 
	 * @param account
	 * @param status
	 * constructor create account with options status
	 */
	public Account(Account account, StatusAccount status){
		this(account.userName, account.email, account.password, status);
	}
	
	/**
	 * 
	 * @param userName
	 * @param email
	 * @param password
	 * constructor create account with status disable
	 */
	public Account(String userName, String email, String password) {
		this(userName, email, password,StatusAccount.DIASBLE);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public StatusAccount getStatusAccount() {
		return statusAccount;
	}
	public void setStatusAccount(StatusAccount statusAccount) {
		this.statusAccount = statusAccount;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
