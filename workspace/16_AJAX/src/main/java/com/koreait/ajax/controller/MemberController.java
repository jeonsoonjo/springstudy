package com.koreait.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping(value="manageMember.do")
	public String manageMember() {
		return "member/manageMember";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


