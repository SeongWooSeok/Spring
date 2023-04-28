package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Security";
	}
	@RequestMapping("/guest/welcome")
	public String welcomeGuest() {
		System.out.println("guest");
		return "guest/welcomeGuest";
	}
	@RequestMapping("/member/welcome")
	public String welcomeMember() {
		System.out.println("member");
		return "member/welcomeMember";
	}
	@RequestMapping("/admin/welcome")
	public String welcomeAdmin() {
		System.out.println("admin");
		return "admin/welcomeAdmin";
	}
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("login form");
		return "security/loginForm";
	}
	@RequestMapping("/loginError")
	public String loginError(){
		System.out.println("login error");
		return "security/loginError";
	}
    @RequestMapping("/forward")
    public @ResponseBody String forward() {
    	System.out.println("forward");
    	return "here";
    }
}











