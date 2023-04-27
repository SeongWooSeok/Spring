package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IBasicBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	IBasicBbsDao dao;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlist(Model model) {
		model.addAttribute("list",dao.listDao());
		return "list";
	}
	
	@RequestMapping("/write")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/writing")
	public String write(HttpServletRequest req,Model model) {
		dao.writeDao(req.getParameter("writer")
				, req.getParameter("title")
				, req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String detailView(HttpServletRequest req,Model model) {
		String uId=req.getParameter("id");
		model.addAttribute("dto",dao.viewDao(uId));
		return "view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req,Model model) {
		dao.deleteDao(req.getParameter("id"));
		return "redirect:list";
	}
}








