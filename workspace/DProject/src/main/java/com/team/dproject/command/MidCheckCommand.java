package com.team.dproject.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team.dproject.dao.MemberDAO;



public class MidCheckCommand{

	public Map<String, Integer> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String mId = request.getParameter("mId");
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("count", memberDAO.mIdCheck(mId));
		return resultMap;

	}

}

