package com.koreait.test.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {

	private long no;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regdate;
	
}

