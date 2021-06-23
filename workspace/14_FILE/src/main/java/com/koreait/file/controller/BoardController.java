package com.koreait.file.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.command.DownloadCommand;
import com.koreait.file.command.InsertBoardCommand;
import com.koreait.file.command.SelectBoardListCommand;

import selectBoardByNo.SelectBoardViewCommand;

@Controller
public class BoardController {

	// field
	private SqlSession sqlSession;
	private SelectBoardListCommand selectBoardListCommand;
	private InsertBoardCommand insertBoardCommand;
	private DownloadCommand downloadCommand;
	private SelectBoardViewCommand selectBoardViewCommand;
	
	// constructor
	@Autowired
	public BoardController(SqlSession sqlSession,
						   SelectBoardListCommand selectBoardListCommand,
						   InsertBoardCommand insertBoardCommand,
						   DownloadCommand downloadCommand,
						   SelectBoardViewCommand selectBoardViewCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectBoardListCommand = selectBoardListCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.downloadCommand = downloadCommand;
		this.selectBoardViewCommand = selectBoardViewCommand;
	}
	
	// method
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.execute(sqlSession, model);
		return "board/listBoard";
	}
	
	@GetMapping(value="insertBoardPage.do") // 단순이동
	public String insertBoardPage() {
		return "board/insertBoard";
	}
	
	@PostMapping(value="insertBoard.do") // insertBoard.jsp에 method="post"
	public String insertBoard(MultipartHttpServletRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest); // insertBoardCommand에 전달하기 위해
		insertBoardCommand.execute(sqlSession, model);
		return "redirect:selectBoardList.do";
	}
	
	@GetMapping(value="download.do")
	public void download(HttpServletRequest request,
						 HttpServletResponse response, // 다운로드할 경로를 알아야 하기에 response가 필요
						 Model model) { 
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		downloadCommand.execute(model);
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		selectBoardViewCommand.execute(sqlSession, model);
		return "board/viewBoard";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


