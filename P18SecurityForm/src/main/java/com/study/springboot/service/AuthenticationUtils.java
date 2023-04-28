package com.study.springboot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUtils {
	public List<String> getAuthorities() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		Collection<? extends GrantedAuthority> authorities 
										= auth.getAuthorities();
		List<String> authList = new ArrayList<>();
		Iterator<? extends GrantedAuthority> iter = authorities.iterator();
		while(iter.hasNext()) {
			GrantedAuthority authority=iter.next();
			System.out.println(authority.getAuthority());
			authList.add(authority.getAuthority());
		}		
		return authList;
	}
}




