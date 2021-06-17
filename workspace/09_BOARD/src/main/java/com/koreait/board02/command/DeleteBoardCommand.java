package com.koreait.board02.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;


public class DeleteBoardCommand implements BoardCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		long no = (Long)map.get("no");
		
		boardDAO.deleteBoard(no);
		
		// 메시지를 출력하고 싶으면 int result = boardDAO.deleteBoard(no); result가 필요하다
		// if(result > 0){response. } script에 메시지를 쓰기 위해서 response가 필요한데(응답 받을)
		// controller에서 매개변수에 response를 선언하면 된다

	}

}

