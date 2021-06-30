package com.koreait.search.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.search.command.AutoCompleteCommand;
import com.koreait.search.command.SearchAllCommand;
import com.koreait.search.dto.QueryDTO;

@Controller
public class SearchController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	private SqlSession sqlSession;
	private SearchAllCommand searchAllCommand;
	private AutoCompleteCommand autoCompleteCommand;
	
	// constructor
	@Autowired
	public SearchController(SqlSession sqlSession,
							SearchAllCommand searchAllCommand,
							AutoCompleteCommand autoCompleteCommand) {
		super();
		this.sqlSession = sqlSession;
		this.searchAllCommand = searchAllCommand;
		this.autoCompleteCommand = autoCompleteCommand;
	}

	// method
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		// logger.info("call index()");
		return "index";
	}
	
	@GetMapping(value="searchAll.do")
	public String searchAll(HttpServletRequest request,
							Model model) {
		model.addAttribute("request", request);
		searchAllCommand.execute(sqlSession, model);
		return "list";
	}
	
	@GetMapping(value="autoComplete.do")
	@ResponseBody
	public void autoComplete(@RequestBody QueryDTO queryDTO,
							 HttpServletResponse response,
							 Model model) {
		model.addAttribute("queryDTO", queryDTO);
		model.addAttribute("response", response);
		autoCompleteCommand.execute(sqlSession, model);
	}
	
	
	
	
	
	
	
	
	
	
}

