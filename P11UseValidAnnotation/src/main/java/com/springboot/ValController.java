package com.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class ValController {
	@RequestMapping("/")
	public String root() {
		return "insertForm";
	}
	
	@RequestMapping("/done")
	public String insert(@ModelAttribute("dto") @Valid ContentDTO contentDto, BindingResult result ) {
		String page="donePage";
		if(result.hasErrors()) {
			System.out.println("getAllErrors : " + result.getAllErrors());
			if(result.getFieldError()!=null) {
				System.out.println("error" + result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content")!=null){
				System.out.println("error" + result.getFieldError("content").getCode());				
			}
			page= "insertForm";
		}
		return page;
	}
}
