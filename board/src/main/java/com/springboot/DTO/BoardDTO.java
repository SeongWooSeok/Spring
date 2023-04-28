package com.springboot.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
}
