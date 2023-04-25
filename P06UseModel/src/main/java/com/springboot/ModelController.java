package com.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Model and View";
	}
	
	@RequestMapping("/test1")
	public String test(Model model) {
		//Model 객체를 이용 view에 data 전달
		//data만 설정 가능
		model.addAttribute("name" , "홍길동");
		return "test1";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test2() {
		//데이터와 뷰를 동시에 설정 가능
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<>();
		list.add("나");
		list.add("너");
		list.add("우리");
		
		mv.addObject("lists", list);
		mv.addObject("objectTest", "test");
		mv.addObject("name", "홍길동");
		mv.setViewName("myView");
		
		return mv;
	}
}
