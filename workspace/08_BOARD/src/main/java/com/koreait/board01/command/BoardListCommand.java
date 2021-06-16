package com.koreait.board01.command;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		
		model.addAttribute("list", BoardDAO.getInstance().selectBoardList());

	}

}
