package com.koreait.final1.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private int bIdx;
	private String bWriter;
	private String bTitle;
	private String bContent;
	private Date bDate;
	
}
