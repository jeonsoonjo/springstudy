package com.koreait.myproject.dao;

import com.koreait.myproject.dto.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(MemberDTO memberDTO);
	public int idCheck(String id);
	public int emailCheck(String email);
	public int join(MemberDTO memberDTO);
	public int updatePw(MemberDTO memberDTO);
	public int updateMember(MemberDTO memberDTO);
	public int deleteMember(MemberDTO memberDTO);
	public void loginLog(MemberDTO memberDTO);
	public void logoutLog(MemberDTO memberDTO);
	
	
	
}

