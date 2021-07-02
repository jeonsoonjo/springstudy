package com.koreait.test.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private long idx;
	private String writer;
	private String title;
	private String content;
	private int hit;
	private String ip;
	private String filename;
	private Date postdate;
	private Date lastmodified;
	
}

