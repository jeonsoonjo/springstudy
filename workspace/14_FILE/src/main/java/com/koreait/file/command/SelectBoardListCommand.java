package com.koreait.file.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.file.dao.BoardDAO;

public class SelectBoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
		
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		model.addAttribute("list", boardDAO.selectBoardList());

	}

}
