package com.koreait.board02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.board02.command.DeleteBoardCommand;
import com.koreait.board02.command.InsertBoardCommand;
import com.koreait.board02.command.SelectBoardListCommand;
import com.koreait.board02.command.SelectBoardViewCommand;
import com.koreait.board02.command.UpdateBoardCommand;
import com.koreait.board02.dto.Board;

@Controller
public class BoardController {

	// field
	private SelectBoardListCommand selectBoardListCommand;
	private SelectBoardViewCommand selectBoardViewCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	private InsertBoardCommand insertBoardCommand;
	
	@Autowired
	public void setCommand(SelectBoardListCommand selectBoardListCommand,
						   SelectBoardViewCommand selectBoardViewCommand,
						   UpdateBoardCommand updateBoardCommand,
						   DeleteBoardCommand deleteBoardCommand,
						   InsertBoardCommand insertBoardCommand) {
		this.selectBoardListCommand = selectBoardListCommand;
		this.selectBoardViewCommand = selectBoardViewCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
		this.insertBoardCommand = insertBoardCommand;
	}
	
	// method
	@GetMapping(value="/")
	public String index() {
		return "index"; // index.jsp로 forward라는 의미
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.execute(model);
		return "board/list";
		// board/list.jsp로 forward
		// selectBoardListCommand model.addAttribute에 저장한 속성이 넘어감
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(@RequestParam("no") long no, Model model) { // @requestParam 애너테이션을 사용했을 때
		model.addAttribute("no", no); // parameter로 전달 받은 no를 SelectBoardViewCommand에게 no를 넘겨주기 위해서
		selectBoardViewCommand.execute(model);
		return "board/view"; 
		// board/view.jsp로 forward
		// selectBoardViewCommand model.addAttribute에 저장한 속성이 넘어감
	}
	
	@PostMapping(value="updateBoardPage.do")
	public String updateBoardPage(Board board, Model model) {
		model.addAttribute("board", board);
		return "board/update";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(HttpServletRequest request, // update.jsp에서 전달한 파라미터
							  Model model) {
		model.addAttribute("req", request); // UpdateBoardCommand에게 request를 전달하기 위해서
		updateBoardCommand.execute(model);
		return "redirect:selectBoardByNo.do?no=" + request.getParameter("no");
		// selectBoardByNo.do 매핑으로 redirect(insert, update, delete는 무조건 redirect!!)
		// no를 가지고 전달해야 하기 때문에  request에서 빼야 한다
	}
	
	@GetMapping(value="deleteBoard.do")
	public String deleteBoard(@RequestParam("no") long no,
							  Model model) {
		model.addAttribute("no", no); // DeleteBoardCommand에게 request를 전달하기 위해서
		deleteBoardCommand.execute(model);
		return "redirect:selectBoardList.do";
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		return "board/insert";
	}
	
	@GetMapping(value="insertBoard.do")
	public String insertBoard(Board board, Model model) {
		model.addAttribute("board", board); // InsertBoardCommand에게 request를 전달하기 위해서
		insertBoardCommand.execute(model); 
		return "redirect:selectBoardList.do";
	}
	
}

