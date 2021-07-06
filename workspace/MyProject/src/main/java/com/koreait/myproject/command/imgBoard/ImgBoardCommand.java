package com.koreait.myproject.command.imgBoard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface ImgBoardCommand {

	public void execute(SqlSession sqlSession, Model model);

}

