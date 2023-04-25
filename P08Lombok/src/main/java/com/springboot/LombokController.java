package com.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LombokController {
	@RequestMapping("/")
	public String root() {
		return "form";
	}
	
	@RequestMapping("/test1")
	public String test1(@ModelAttribute("person") PersonDTO person, Model model) {
//		model.addAttribute("person", person);
//		System.out.println(person.toString());
		return "test1";
	}
}
