package com.koreait.ajax.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController // 모든 메소드의 전환값을 @ResponseBody로 처리한다
public class MemberRestController {

	// 앞으로 모든 메소드는 @ResponseBody 애너테이션을
	// 추가하지 않아도 ajax 처리가 된다
	
	// field
	private SqlSession sqlSession;

	// constructor
	@Autowired
	public MemberRestController(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	
	
	
	
	
}


