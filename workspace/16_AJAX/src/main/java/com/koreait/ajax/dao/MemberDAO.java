package com.koreait.ajax.dao;

import java.util.List;
import org.springframework.dao.DuplicateKeyException;

import com.koreait.ajax.dto.Member;
import com.koreait.ajax.dto.Page;

public interface MemberDAO {

	public int insertMember(Member member) throws DuplicateKeyException;
	public int getTotalMemberCount(); // 전체 인원 구하기
	public List<Member> selectMemberList(Page paging);
	public Member selectMemberByNo(long no);
	
	
	
}

