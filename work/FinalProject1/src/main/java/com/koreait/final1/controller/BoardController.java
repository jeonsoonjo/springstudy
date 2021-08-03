package com.koreait.final1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.final1.command.DeleteBoardCommand;
import com.koreait.final1.command.InsertBoardCommand;
import com.koreait.final1.command.SelectBoardListCommand;
import com.koreait.final1.command.SelectBoardViewCommand;
import com.koreait.final1.command.UpdateBoardCommand;


@Controller
public class BoardController {

	private SqlSession sqlSession;
	private SelectBoardListCommand selectBoardListCommand;
	private SelectBoardViewCommand selectBoardViewCommand;
	private InsertBoardCommand insertBoardCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;

	@Autowired
	public BoardController(SqlSession sqlSession,
						   SelectBoardListCommand selectBoardListCommand,
						   SelectBoardViewCommand selectBoardViewCommand,
						   InsertBoardCommand insertBoardCommand,
						   UpdateBoardCommand updateBoardCommand,
						   DeleteBoardCommand deleteBoardCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectBoardListCommand = selectBoardListCommand;
		this.selectBoardViewCommand = selectBoardViewCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
	}
	
	@GetMapping(value= "/")
	public String index() {
		return "index";
	}

	// 게시글 목록(selectBoardList)
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.execute(sqlSession, model);
		return "board/list";
	}

	// 게시글 반환(selectBoardByIdx)
	@GetMapping(value = "selectBoardByIdx.do")
	public String view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		selectBoardViewCommand.execute(sqlSession, model);
		return "board/view";
	}
		
	// 게시글 등록 페이지 단순이동
	@GetMapping(value = "insertBoardPage.do")
	public String insertBoardPage() {
		return "board/insert";
	}

	// 게시글 등록(insertBoard)
	@PostMapping(value = "insertBoard.do")
	public void insertBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		insertBoardCommand.execute(sqlSession, model);
	}

	// 게시글 수정(updateBoard)
	@GetMapping(value = "updateBoard.do")
	public void updateBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		updateBoardCommand.execute(sqlSession, model);
	}

	// 게시글 삭제(deleteBoard)
	@GetMapping(value = "deleteBoard.do")
	public void delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		deleteBoardCommand.execute(sqlSession, model);
	}
	
}
