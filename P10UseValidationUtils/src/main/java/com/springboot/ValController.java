package com.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValController {
	@RequestMapping("/")
	public String root() {
		return "insertForm";
	}
	
	@RequestMapping("/done")
	public String insert(@ModelAttribute("dto") ContentDTO contentDto, BindingResult result ) {
		String page="donePage";
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
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
