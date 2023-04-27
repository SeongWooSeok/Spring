package com.study.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.BasicBbsDto;

@Mapper
public interface IBasicBbsDao {
	//게시물 전체보기
	public List<BasicBbsDto> listDao();
	//게시물 상세보기
	public BasicBbsDto viewDao(String id);
	//게시물 작성
	public int writeDao(Map<String,String> map);
	//게시물 삭제
	public int deleteDao(@Param("_id") String id);
	//게시물 전체 숫자
	public int postCount();
}
