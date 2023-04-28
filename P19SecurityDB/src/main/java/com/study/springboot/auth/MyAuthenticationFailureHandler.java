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
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,
			AuthenticationException exception) throws IOException, ServletException {
		
		String id = req.getParameter("j_username");
		String errormsg="";
		//SecurityContextHolder(Security Context)
		//Authentication(
		//        principal(아이디) Credentials(비밀번호) authorities(권한목록)
		//  )
		
		if(exception instanceof BadCredentialsException) {
			errormsg="아이디나 비밀번호가 일치하지 않습니다. 다시 확인해주세요";
		}else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg="내부적인 시스템 문제로 인해 인증 요청을 처리할 수 없습니다.";
		}else if(exception instanceof DisabledException) {
			errormsg="계정이 비활성되었습니다.";
		}else if(exception instanceof CredentialsExpiredException) {
			errormsg="비밀번호 유효기간이 만료되었습니다.";
		}
		
		req.setAttribute("username", id);
		req.setAttribute("error_message", errormsg);
		req.getRequestDispatcher("loginForm?error").forward(req, resp);

	}

}
