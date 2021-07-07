package com.koreait.myproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject.command.imgBoard.InsertImgBoardCommand;
import com.koreait.myproject.command.imgBoard.SelectImgBoardListCommand;
import com.koreait.myproject.command.imgBoard.SelectImgBoardViewCommand;
import com.koreait.myproject.command.imgBoard.UpdateImgBoardCommand;

@Controller
public class ImgBoardController {

	// field
	private SqlSession sqlSession;
	private SelectImgBoardListCommand selectImgBoardListCommand;
	private SelectImgBoardViewCommand selectImgBoardViewCommand;
	private InsertImgBoardCommand insertImgBoardCommand;
	private UpdateImgBoardCommand updateImgBoardCommand;
	
	// constructor
	@Autowired
	public ImgBoardController(SqlSession sqlSession,
							  SelectImgBoardListCommand selectImgBoardListCommand,
							  SelectImgBoardViewCommand selectImgBoardViewCommand,
							  InsertImgBoardCommand insertImgBoardCommand,
							  UpdateImgBoardCommand updateImgBoardCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectImgBoardListCommand = selectImgBoardListCommand;
		this.selectImgBoardViewCommand = selectImgBoardViewCommand;
		this.insertImgBoardCommand = insertImgBoardCommand;
		this.updateImgBoardCommand = updateImgBoardCommand;
	}
	
	// 이미지 게시판 목록(selectImgBoardList)
	@GetMapping(value="selectImgBoardList.do")
	public String selectImgBoardList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		selectImgBoardListCommand.execute(sqlSession, model);
		return "imgBoard/listImgBoard"; 
	}
	// 게시글 반환(selectImgBoardByIdx)
	@GetMapping(value="selectImgBoardByIdx.do")
	public String selectImgBoardByIdx(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		selectImgBoardViewCommand.execute(sqlSession, model);
		return "imgBoard/viewImgBoard";
	}
	// insertImgBoardPage 단순이동
	@GetMapping(value="insertImgBoardPage.do") // 단순이동
	public String insertImgBoardPage() {
		return "imgBoard/insertImgBoard";
	}
	// 게시글 등록(insertImgBoard)
	@PostMapping(value="insertImgBoard.do")
	public String insertImgBoard(MultipartHttpServletRequest multipartRequest, Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		insertImgBoardCommand.execute(sqlSession, model);
		return "redirect:selectImgBoardList.do"; 
	}
	// 게시글 수정(updateImgBoard)
	@PostMapping(value="updateImgBoard.do")
	public String updateBoard(MultipartHttpServletRequest multipartRequest, Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		updateImgBoardCommand.execute(sqlSession, model);
		return "redirect:selectImgBoardByIdx.do?idx=" + multipartRequest.getParameter("idx");
	}
	
	
	
	
	
	
	
	
}

