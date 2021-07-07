package com.koreait.myproject.controller;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.myproject.command.board.InsertBoardCommand;
import com.koreait.myproject.command.board.SelectBoardListCommand;

@Controller
public class BoardController {

	// field
	private SqlSession sqlSession;
	private SelectBoardListCommand selectBoardListCommand;
	private InsertBoardCommand insertBoardCommand;
	
	// constructor
	@Autowired
	public BoardController(SqlSession sqlSession,
						   SelectBoardListCommand selectBoardListCommand,
						   InsertBoardCommand insertBoardCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectBoardListCommand = selectBoardListCommand;
		this.insertBoardCommand = insertBoardCommand;
	}
	
	// 게시글 목록
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		selectBoardListCommand.execute(sqlSession, model);
		return "board/listBoard"; 
	}
	// insertBoardPage 단순이동
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		return "board/insert"; 
	}
	// 게시글 등록(insertBoard)
	@GetMapping(value="insertBoard.do")
	public String insertBoard(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		insertBoardCommand.execute(sqlSession, model);
		return "redirect:selectBoardList.do";
	}
	
	
	
	
	
	
	
	
}

