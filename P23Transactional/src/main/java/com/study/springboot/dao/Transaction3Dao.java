package com.study.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Transaction3Dao {
	public void deposit(String accountid, int amount);
}
