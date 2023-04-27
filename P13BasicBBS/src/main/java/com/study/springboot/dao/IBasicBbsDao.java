package com.study.springboot.dao;

import java.util.List;

import com.study.springboot.dto.BasicBbsDto;

public interface IBasicBbsDao {
	//게시물 전체보기
	public List<BasicBbsDto> listDao();
	//게시물 상세보기
	public BasicBbsDto viewDao(String id);
	//게시물 작성
	public int writeDao(String writer,String title,String content);
	//게시물 삭제
	public int deleteDao(String id);
}
