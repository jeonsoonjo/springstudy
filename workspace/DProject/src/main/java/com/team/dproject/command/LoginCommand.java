package com.team.dproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team.dproject.dao.MemberDAO;
import com.team.dproject.dto.MemberDTO;

public class LoginCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMId(mId);
		memberDTO.setMPw(mPw);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO loginUser = memberDAO.login(memberDTO);
		
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
		}
		
	}

}
