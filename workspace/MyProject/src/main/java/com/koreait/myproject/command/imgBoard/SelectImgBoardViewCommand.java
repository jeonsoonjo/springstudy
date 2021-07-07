package com.koreait.myproject.command.imgBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.ImgBoardDAO;


public class SelectImgBoardViewCommand implements ImgBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long idx = Long.parseLong(request.getParameter("idx"));
		
		ImgBoardDAO imgBoardDAO = sqlSession.getMapper(ImgBoardDAO.class);
		model.addAttribute("imgBoard", imgBoardDAO.selectImgBoardByIdx(idx));

	}

}


