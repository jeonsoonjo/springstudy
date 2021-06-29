package com.koreait.test.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	// field
	private SqlSession sqlSession;
	
	
	// constructor
	@Autowired
	public MemberController(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	// method
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
	
	
	
	
	
	
	
}

