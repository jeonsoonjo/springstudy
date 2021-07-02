package com.koreait.test.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.test.dao.MemberDAO;
import com.koreait.test.dto.MemberDTO;

public class LoginCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO loginUser = memberDAO.login(memberDTO);
		
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
		}

	}

}

