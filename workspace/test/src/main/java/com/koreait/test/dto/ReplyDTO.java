package com.koreait.test.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDTO {

	private long idx;
	private String author;
	private String content;
	private String ip;
	private long boardIdx;
	private Date postdate;
	
}

