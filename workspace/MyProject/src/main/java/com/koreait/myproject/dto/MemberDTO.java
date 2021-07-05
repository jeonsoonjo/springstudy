package com.koreait.myproject.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class MemberDTO {

	private long no; // 회원 번호
	private String id; // 아이디
	private String pw; // 비밀번호
	private String name; // 이름
	private String phone; // 전화번호
	private String email; // 이메일
	private String address; // 주소
	private Date regdate; // 가입일
	private int state; // 정상여부(정상: 0, 삭제: -1)
	
}

