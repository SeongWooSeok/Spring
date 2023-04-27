package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.IBasicBbsDao;
import com.study.springboot.dto.BasicBbsDto;

@Service
public class BasicBbsServiceImpl implements BasicBbsService{
	@Autowired
	IBasicBbsDao dao;
	
	@Override
	public List<BasicBbsDto> getList() {
		return dao.listDao();
	}

	@Override
	public BasicBbsDto getView(String id) {
		return dao.viewDao(id);
	}

	@Override
	public int writePost(Map<String, String> map) {
		return dao.writeDao(map);
	}

	@Override
	public int deletePost(String id) {
		return dao.deleteDao(id);
	}

	@Override
	public int countPost() {
		return dao.postCount();
	}
	
}
