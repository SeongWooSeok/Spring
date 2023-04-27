package com.study.springboot.dto;

import lombok.Data;

@Data
public class BasicBbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
}
