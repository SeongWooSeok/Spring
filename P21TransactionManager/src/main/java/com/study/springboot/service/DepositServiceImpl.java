package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

@Service
public class DepositServiceImpl implements IDepositService {
   
   @Autowired
   Transaction1Dao trans1;
   @Autowired
   Transaction2Dao trans2;
   
   
   @Autowired
   PlatformTransactionManager trManager;
   
   @Autowired
   TransactionDefinition trDef;
   
   @Override
   public int deposit(String accountid, int money, String error) {
	   TransactionStatus status = trManager.getTransaction(trDef);
	   try {
         trans1.deposit(accountid, money);
         if(error.equals("1")) {
            int n=10/0;
         }
         trans2.deposit(accountid, money);
         
         trManager.commit(status);
         
         return 1;
      }catch(Exception e) {
    	  trManager.rollback(status);
    	  System.out.println("PlatformTransactionManager rollback");
         return 0;
      }
   }

}