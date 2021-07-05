package com.koreait.myproject.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dto.MemberDTO;

public class PresentPwCheckCommand{

	public Map<String, Boolean> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MemberDTO memberDTO = (MemberDTO)map.get("memberDTO");
		HttpSession session = (HttpSession)map.get("session");
		
		String pw1 = ((MemberDTO)session.getAttribute("loginUser")).getPw(); 
		String pw2 = memberDTO.getPw(); 
		
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isCorrect", pw1.equals(pw2)); // pw1과 pw2 비교
		return resultMap;

	}

}

