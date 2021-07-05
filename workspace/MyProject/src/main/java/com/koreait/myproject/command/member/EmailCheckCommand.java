package com.koreait.myproject.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.MemberDAO;

public class EmailCheckCommand{

	public Map<String, Integer> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String email = request.getParameter("email");
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("count", memberDAO.emailCheck(email));
		return resultMap;
		
	}

}

