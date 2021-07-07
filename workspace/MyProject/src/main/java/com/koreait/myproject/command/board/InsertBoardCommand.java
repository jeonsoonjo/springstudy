package com.koreait.myproject.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.BoardDAO;
import com.koreait.myproject.dto.BoardDTO;
public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
	
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setWriter(writer);
		boardDTO.setTitle(title);
		boardDTO.setContent(content);
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		boardDAO.insertBoard(boardDTO);
			
	}

}
