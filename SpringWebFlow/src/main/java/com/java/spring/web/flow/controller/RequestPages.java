package com.java.spring.web.flow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestPages {
	
	@RequestMapping(value={"/","","/index/","/index"})
	public String getIndexPage(){
		return "index";
	}
}
