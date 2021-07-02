package com.koreait.myproject.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class MemberLogDTO {

	private long no; // 회원 번호
	private String id; // 아이디
	private Date login; // 로그인
	private Date logout; // 로그아웃
	
}

