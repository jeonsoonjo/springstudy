package com.team.dproject.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team.dproject.dao.MemberDAO;
import com.team.dproject.dto.MemberDTO;

public class JoinCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		String mName = request.getParameter("mName");
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		String mEmail = request.getParameter("mEmail");
		String mPhone = request.getParameter("mPhone");
		String mGrade = request.getParameter("mGrade");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMName(mName);
		memberDTO.setMId(mId);
		memberDTO.setMPw(mPw);
		memberDTO.setMEmail(mEmail);
		memberDTO.setMPhone(mPhone);
		memberDTO.setMGrade(mGrade);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int result = memberDAO.join(memberDTO);
		
		try {
			response.setContentType("text/html; charset=utf-8");
			if (result > 0) {
				response.getWriter().append("<script>");
				response.getWriter().append("alert('회원가입이 완료되었습니다. 로그인하세요.');");
				response.getWriter().append("location.href='index.do';");
				response.getWriter().append("</script>");
			} else {
				response.getWriter().append("<script>");
				response.getWriter().append("alert('회원가입에 실패했습니다.');");
				response.getWriter().append("history.back();");
				response.getWriter().append("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

