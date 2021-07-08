package com.team.dproject.dao;

import com.team.dproject.dto.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(MemberDTO memberDTO);
	public int mIdCheck(String mId);
	public int join(MemberDTO memberDTO);
	
}

