package com.springboot.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {
	public void getList();
}
