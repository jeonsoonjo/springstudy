package com.koreait.myproject.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dto.MemberDTO;
import com.koreait.myproject.util.SecurityUtils;

public class PresentPwCheckCommand{

	public Map<String, Boolean> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MemberDTO memberDTO = (MemberDTO)map.get("memberDTO");
		HttpSession session = (HttpSession)map.get("session");
		
		String pw1 = ((MemberDTO)session.getAttribute("loginUser")).getPw(); // session에 저장된 암호화가 되어 있는  비밀번호
		String pw2 = SecurityUtils.encodeBase64(memberDTO.getPw()); // 암호화가 되어 있지 않은 비밀번호
		
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isCorrect", pw1.equals(pw2)); // pw1과 pw2 비교
		return resultMap;

	}

}

