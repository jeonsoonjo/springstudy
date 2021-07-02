package com.koreait.test.dao;

import com.koreait.test.dto.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(MemberDTO memberDTO);
	public int idCheck(String id);
	public int join(MemberDTO memberDTO);
	
	
	
	
	
	
	
	
}

