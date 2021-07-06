package com.koreait.myproject.dto;

import lombok.Data;

@Data
public class PageDTO {

	// field
	private int page;
	private int totalRecord;
	private int recordPerPage;
	private int beginRecord;
	private int endRecord;
	private int totalPage;
	private int pagePerBlock;
	private int beginPage;
	private int endPage;
	
}

