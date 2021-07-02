package com.koreait.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.integration.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

