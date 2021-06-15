package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.mvc03.dto.Member;

@Controller
public class LoginController {

	@RequestMapping("loginPage.do")
	public String a() {
		return "member/login";
	}
	
	// HttpServletRequest
	/*
		@RequestMapping("login.do") // 매핑값이 같을 순 없다. 절대! 서버다운 됨
		public String b(HttpServletRequest request, Model model) {
			model.addAttribute("id", request.getParameter("id"));
			model.addAttribute("pw", request.getParameter("pw"));
			
			return "member/loginResult";
		}
	*/
	
	// DTO
	@RequestMapping("login.do")
	public String b(Member member, Model model) {
		model.addAttribute("id", member.getId());
		model.addAttribute("pw", member.getPw());
		
		return "member/loginResult";
	}
	
	
}


