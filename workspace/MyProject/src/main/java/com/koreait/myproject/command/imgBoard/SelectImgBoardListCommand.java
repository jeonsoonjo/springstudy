package com.koreait.myproject.command.imgBoard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.ImgBoardDAO;

public class SelectImgBoardListCommand implements ImgBoardCommand {

		@Override
		public void execute(SqlSession sqlSession, Model model) {
			
			ImgBoardDAO imgBoardDAO = sqlSession.getMapper(ImgBoardDAO.class);
			model.addAttribute("imgList", imgBoardDAO.selectImgBoardList());
	
		}
		
}



