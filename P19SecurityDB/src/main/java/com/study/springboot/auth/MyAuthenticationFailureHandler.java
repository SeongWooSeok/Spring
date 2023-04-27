package com.study.springboot.auth;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			String id=request.getParameter("j_username");
			String errormsg="";
			//SecurityContextHolder(Security Context)
			//	Authentication(
			//	Principal(아이디) Credentials(비밀번호) Authorities(권한목록)
			//	)
			if(exception instanceof BadCredentialsException) {
				errormsg="<mark>아이디</mark>나 <del>비번이</del> 맞지않음";
			}else if(exception instanceof InternalAuthenticationServiceException) {
				errormsg="시스템문제로 인증ㄴ";
			}else if(exception instanceof DisabledException) {
				errormsg="계정이 비활성화";
			}else if(exception instanceof CredentialsExpiredException) {
				errormsg="비밀번호 유효기간 끝";
			}
				
			request.setAttribute("username", id);
			request.setAttribute("error_message", errormsg);
			request.getRequestDispatcher("loginForm?error").forward(request, response);
	}
}
