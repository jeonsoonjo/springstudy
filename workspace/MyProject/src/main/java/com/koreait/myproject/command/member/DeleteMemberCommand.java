package com.koreait.myproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.MemberDAO;
import com.koreait.myproject.dto.MemberDTO;


public class DeleteMemberCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long no = Long.parseLong(request.getParameter("no"));
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setNo(no);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.deleteMember(memberDTO);
		
		if(count > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			
		}

	}

}

