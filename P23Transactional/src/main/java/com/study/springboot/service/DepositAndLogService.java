package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class DepositAndLogService {
	@Autowired
	DepositServiceImpl depositS;
	@Autowired
	LogService logS;
	@Autowired
	TransactionTemplate tTemp;
	
	public int deposit(String accountid, int amount, String error) {
		try {
			tTemp.execute(new TransactionCallbackWithoutResult() {	
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					depositS.deposit(accountid, amount, error);
					if(error.equals("2")) {int n = 10/0;}
					logS.logWrite(accountid, amount);
				}
			});
			return 1;
		} catch (Exception e) {
			System.out.println("transaction deposit and log rollback");
			return 0;
		}
	}
	
	
	
}
