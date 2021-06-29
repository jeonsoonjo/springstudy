package com.koreait.test.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberLogDTO {

	private long no;
	private String id;
	private Date login;
	private Date logout;
	
}

