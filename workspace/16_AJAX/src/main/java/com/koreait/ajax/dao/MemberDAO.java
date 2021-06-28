package com.koreait.ajax.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import com.koreait.ajax.dto.Member;

public interface MemberDAO {

	public int insertMember(Member member) throws SQLIntegrityConstraintViolationException;
	public int getTotalMemberCount(); // 전체 인원 구하기
	public List<Member> selectMemberList(Map<String, Integer> map);
	
	
	
	
}

