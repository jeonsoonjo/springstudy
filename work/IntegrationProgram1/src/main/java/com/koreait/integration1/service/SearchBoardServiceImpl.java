package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.integration1.domain.SearchBoard;
import com.koreait.integration1.repository.SearchBoardRepository;

// SearchBoardService의 method 구현
@Service
public class SearchBoardServiceImpl implements SearchBoardService {

	@Autowired
	private SearchBoardRepository repository;
	
	@Override
	public int getTotalCount(long no) {
		return repository.getTotalCount(no);
	}
	
	@Override
	public List<SearchBoard> totalList() {
		return repository.selectAll();
	}
	
	@Override
	public List<SearchBoard> searchList(Map<String, String> map) {
		return repository.selectQuery(map);
	}

	
}

