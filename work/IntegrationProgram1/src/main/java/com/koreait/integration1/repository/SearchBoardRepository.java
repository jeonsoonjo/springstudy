package com.koreait.integration1.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.integration1.domain.SearchBoard;

@Repository
public class SearchBoardRepository {

	@Autowired
	private SqlSession sqlSession;

	public int getTotalCount(long no) {
		return sqlSession.selectOne("com.koreait.integration1.repository.searchBoard.getTotalCount");
	}
	
	public List<SearchBoard> selectAll(){
		return sqlSession.selectList("com.koreait.integration1.repository.searchBoard.selectAll");
	}
	
	public List<SearchBoard> selectQuery(Map<String, String> map){
		return sqlSession.selectList("com.koreait.integration1.repository.searchBoard.selectQuery", map);
	}
	

}


