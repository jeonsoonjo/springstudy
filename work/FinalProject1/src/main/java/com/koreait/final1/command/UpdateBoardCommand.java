package com.koreait.final1.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.final1.dao.BoardDAO;

public class UpdateBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		int bIdx = Integer.parseInt(request.getParameter("bIdx"));

		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.updateBoard(bTitle, bContent, bIdx);
		
		try {
			response.setContentType("text/html; charset=utf-8");
			if (result > 0) {
				response.getWriter().append("<script>");
				response.getWriter().append("alert('수정 성공');");
				response.getWriter().append("location.href='selectBoardByIdx.do?bIdx=" + bIdx + "';");
				response.getWriter().append("</script>");
			} else {
				response.getWriter().append("<script>");
				response.getWriter().append("alert('수정 실패');");
				response.getWriter().append("history.back();");
				response.getWriter().append("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
