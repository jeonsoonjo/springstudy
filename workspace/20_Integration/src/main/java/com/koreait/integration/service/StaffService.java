package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration.domain.Staff;

public interface StaffService {

	public List<Staff> totalList(); 
	public List<Staff> searchList(Map<String, String> map);
	
}

