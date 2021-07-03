package com.koreait.integration.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.integration.domain.Staff;

@Repository
public class StaffRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Staff> selectAll(){
		return sqlSession.selectList("com.koreait.integration.repository.staff.selectAll");
	}
	
	public List<Staff> selectQuery(Map<String, String> map){
		return sqlSession.selectList("com.koreait.integration.repository.staff.selectQuery", map);
	}

	
}

