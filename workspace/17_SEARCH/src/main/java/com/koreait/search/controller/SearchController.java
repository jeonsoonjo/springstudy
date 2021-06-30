package com.koreait.search.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.search.command.AutoCompleteCommand;
import com.koreait.search.command.SearchAllCommand;
import com.koreait.search.command.SearchQueryCommand;
import com.koreait.search.dto.QueryDTO;

@Controller
public class SearchController {

	// field
	// private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	private SqlSession sqlSession;
	private SearchAllCommand searchAllCommand;
	private AutoCompleteCommand autoCompleteCommand;
	private SearchQueryCommand searchQueryCommand;
	
	// constructor
	@Autowired
	public SearchController(SqlSession sqlSession,
							SearchAllCommand searchAllCommand,
							AutoCompleteCommand autoCompleteCommand,
							SearchQueryCommand searchQueryCommand) {
		super();
		this.sqlSession = sqlSession;
		this.searchAllCommand = searchAllCommand;
		this.autoCompleteCommand = autoCompleteCommand;
		this.searchQueryCommand = searchQueryCommand;
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
		return "list"; // SearchAllCommand가 model에 저장한 정보를 가지고 list.jsp로 포워드
	}
	
	@PostMapping(value="autoComplete.do")
	@ResponseBody
	public void autoComplete(@RequestBody QueryDTO queryDTO,
							 HttpServletResponse response,
							 Model model) {
		// logger.info(queryDTO.toString());
		model.addAttribute("queryDTO", queryDTO);
		model.addAttribute("response", response);
		autoCompleteCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="search.do")
	public String search(HttpServletRequest request,
						 Model model) {
		model.addAttribute("request", request);
		searchQueryCommand.execute(sqlSession, model);
		return "list";
	}
	
}

