package com.java.spring.web.flow.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.web.flow.constant.ConstantConfig;
import com.java.spring.web.flow.model.Account;
import com.java.spring.web.flow.service.AccountService;

@Controller
@RequestMapping("/account/")
public class AccountController {
	
	@Autowired
	@Qualifier(AccountService.NAME)
	private AccountService accountSr;
	
	@Value("${" + ConstantConfig.LOGGIN_ERROR + "}") 
	private String msgLoginError;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerPage (Account account){
		return "account/register";
	}
	
	@RequestMapping(value="success")
	public String successPage(){
		return "account/success";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerAccount(@Valid Account account,
			BindingResult bidding,
			@RequestParam(value="image",required = false)MultipartFile image){
		
		if(bidding.hasErrors()){
			return "account/register";
		}
		
		accountSr.registerAcount(account);
		
		return "redirect:success";
		
	}
	
	@RequestMapping(value="login")
	public String getLoginPage(@RequestParam(required= false) boolean error, ModelMap model){
		model.put("errorLogin", error);
		return "login";
	}
	
	@RequestMapping(value="logout")
	public String logOut(){
		return "login";
	}
	
	
}
