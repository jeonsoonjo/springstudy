package com.koreait.myproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.MemberDAO;
import com.koreait.myproject.dto.MemberDTO;

public class JoinCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw); // 비번찾기: SecurityUtils.encodeBase64(pw)
		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		memberDTO.setAddress(address);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.join(memberDTO);
		
	}

}

