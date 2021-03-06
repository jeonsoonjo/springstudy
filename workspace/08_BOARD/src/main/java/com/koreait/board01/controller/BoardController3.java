package com.koreait.board01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.board01.command.BoardListCommand;
import com.koreait.board01.command.BoardViewCommand;
import com.koreait.board01.command.DeleteBoardCommand;
import com.koreait.board01.command.InsertBoardCommand;
import com.koreait.board01.command.UpdateBoardCommand;
import com.koreait.board01.config.BeanConfiguration;
import com.koreait.board01.dto.Board;

@Controller
public class BoardController3 {

	// field
	private static final Logger logger = LoggerFactory.getLogger(BoardController3.class);
	
	// BeanConfiguration.java 이용한 bean 생성
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
	// method
	@GetMapping(value="/") // @RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		logger.info("index() 호출"); 
		return "index";
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) { // execute(model)를 해줘야 하기에 매개변수로 model를 사용해야 한다
		logger.info("selectBoardList() 호출");
		BoardListCommand command = ctx.getBean("boardListCommand", BoardListCommand.class);
		command.execute(model);
		return "board/list"; // board/list.jsp로 이동
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		logger.info("insertBoardPage() 호출");
		return "board/insert";
	}
	
	@GetMapping(value="insertBoard.do")
	public String insertBoard(HttpServletRequest request, // <form> 태그 요소가 파라미터로 전달되기 때문에 request로 전달받을 수 있다
							  Model model) {
		logger.info("insertBoard() 호출");
		// 모든 Command에는 model만 전달할 수 있다
		// 따라서, Command에 전달할 데이터들은 모두 model에 저장해야 한다
		model.addAttribute("request", request);
		InsertBoardCommand command = ctx.getBean("insertBoardCommand", InsertBoardCommand.class);
		command.execute(model);
		return "redirect:selectBoardList.do"; // 게시글 작성 후 목록 보기로 이동(redirect:매핑)
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(@RequestParam("no") long no,
								  Model model) {
		logger.info("selectBoardByNo() 호출");
		model.addAttribute("no", no);
		BoardViewCommand command = ctx.getBean("boardViewCommand", BoardViewCommand.class);
		command.execute(model);
		return "board/view";
	}
	
	@PostMapping(value="updateBoardPage.do")
	public String updateBoardPage(@ModelAttribute Board board) {
		logger.info("updateBoardPage() 호출");
		return "board/update";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(Board board,
							  Model model) {
		logger.info("updateBoard() 호출");
		model.addAttribute("board", board);
		UpdateBoardCommand command = ctx.getBean("updateBoardCommand", UpdateBoardCommand.class);
		command.execute(model);
		return "redirect:selectBoardByNo.do?no=" + board.getNo();
	}
	
	@GetMapping(value="deleteBoard.do")
	public String deleteBoard(@RequestParam("no") long no,
							  Model model) {
		logger.info("deleteBoard() 호출");
		model.addAttribute("no", no);
		DeleteBoardCommand command = ctx.getBean("deleteBoardCommand", DeleteBoardCommand.class);
		command.execute(model);
		return "redirect:selectBoardList.do";
	}
	
}


