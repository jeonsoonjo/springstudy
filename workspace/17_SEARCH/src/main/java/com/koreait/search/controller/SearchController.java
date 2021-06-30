package com.koreait.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.search.command.SearchAllCommand;

@Controller
public class SearchController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	private SqlSession sqlSession;
	private SearchAllCommand searchAllCommand;
	
	// constructor
	@Autowired
	public SearchController(SqlSession sqlSession,
							SearchAllCommand searchAllCommand) {
		super();
		this.sqlSession = sqlSession;
		this.searchAllCommand = searchAllCommand;
	}

	// method
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		logger.info("call index()");
		return "index";
	}
	
	@GetMapping(value="searchAll.do")
	public String searchAll(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		searchAllCommand.execute(sqlSession, model);
		return "list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

