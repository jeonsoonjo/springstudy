package com.koreait.myproject.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private long idx; // 게시글 번호
	private String writer; // 작성자
	private String title; // 제목
	private String content; // 내용
	private String ip; // 작성자 ip
	private int hit; // 조회수
	private Date postdate; // 작성일
	private Date lastmodified; // 최종수정일
	private int state; // 정상여부(정상: 0, 삭제: -1)
	private long groupno; // 게시글의 그룹 여부
	private int groupord; // 그룹 내 표시 순서
	private int depth; // 게시글, 댓글 여부
	
}

