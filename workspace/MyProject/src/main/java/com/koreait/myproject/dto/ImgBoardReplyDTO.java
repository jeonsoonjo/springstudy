package com.koreait.myproject.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ImgBoardReplyDTO {

	private long idx; // 이미지 게시판 댓글 번호
	private String writer; // 작성자
	private String content; // 내용
	private String ip; // 작성자 ip
	private long imgboardIdx; // 원글의 번호(camel형식으로 변경)
	private Date postdate; // 작성일
	
}

