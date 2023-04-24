package com.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Member {
	@Value("나문희")
	private String name;
	@Value("호박고구마")	
	private String nickname;
	@Autowired
	@Qualifier("printerA")
	private Printer printer;
	
	public Member() {}
	
	public Member(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("안녕!" + name+ " : " + nickname);
	}
	
}

/*
 *  @Component

 - 개발자가 직접 작성한 클래스를 bean 등록하고자 할 경우 사용


 @Configuration + @Bean

 - 외부라이브러 또는 내장 클래스를 bean으로 등록하고자 할 경우 사용. 

 - 1개 이상의 @Bean을 제공하는 클래스의 경우 반드시 @Configuraton을 명시
 * */
