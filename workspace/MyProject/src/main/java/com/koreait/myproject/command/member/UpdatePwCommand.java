package com.koreait.myproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.MemberDAO;
import com.koreait.myproject.dto.MemberDTO;
import com.koreait.myproject.util.SecurityUtils;


public class UpdatePwCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String pw = request.getParameter("pw");
		long no = Long.parseLong(request.getParameter("no"));
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setPw(pw);
		memberDTO.setNo(no);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.updatePw(memberDTO);
		if(count > 0) {
			HttpSession session = request.getSession();
			MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser");
			if(loginUser != null) {
				loginUser.setPw(SecurityUtils.encodeBase64(pw));
			}
		}

	}

}

