package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koreait.integration.domain.Staff;
import com.koreait.integration.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository repository;
	
	@Override
	public List<Staff> totalList() {
		return repository.selectAll();
	}

	@Override
	public List<Staff> searchList(Map<String, String> map) {
		return repository.selectQuery(map);
	}

	
}
