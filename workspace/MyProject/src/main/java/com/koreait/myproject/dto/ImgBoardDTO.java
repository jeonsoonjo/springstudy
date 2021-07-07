package com.koreait.myproject.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ImgBoardDTO {

	private long idx; // 이미지 게시판 번호
	private String writer; // 작성자
	private String title; // 제목
	private String content; // 내용
	private String origin_filename; // 원래 파일명
	private String save_filename; // 저장된 파일명
	private String ip; // 작성자 ip
	private int hit; // 조회수
	private Date postdate; // 작성일
	private Date lastmodified; // 최종수정일
	
}
