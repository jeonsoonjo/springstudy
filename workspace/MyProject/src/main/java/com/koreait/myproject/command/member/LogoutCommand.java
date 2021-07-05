package com.koreait.myproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.MemberDAO;
import com.koreait.myproject.dto.MemberDTO;

public class LogoutCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		String id = ((MemberDTO)session.getAttribute("loginUser")).getId();
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDAO.logoutLog(memberDTO);
		
		if(session.getAttribute("loginUser") != null) {
			session.invalidate();
		}

	}

}

