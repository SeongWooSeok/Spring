package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.Transaction3Dao;

@Service
public class LogService {
	@Autowired
	Transaction3Dao trans3;
	public int logWrite(String accountid, int amount) {
		try {
			trans3.deposit(accountid, amount);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
