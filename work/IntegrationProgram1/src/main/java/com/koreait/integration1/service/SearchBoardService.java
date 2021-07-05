package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration1.domain.SearchBoard;

public interface SearchBoardService {

	public int getTotalCount(long no); // getTotalCount
	public List<SearchBoard> totalList(); // selectAll
	public List<SearchBoard> searchList(Map<String, String> map); // selectQuery

	
}
