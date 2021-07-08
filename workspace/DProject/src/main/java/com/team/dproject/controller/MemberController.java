package com.team.dproject.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.dproject.command.JoinCommand;
import com.team.dproject.command.LoginCommand;
import com.team.dproject.command.MidCheckCommand;

@Controller
public class MemberController {

	// field
	private SqlSession sqlSession;
	private LoginCommand loginCommand;
	private JoinCommand joinCommand;
	private MidCheckCommand midCheckCommand;

	// constructor
	@Autowired
	public MemberController(SqlSession sqlSession,
							LoginCommand loginCommand,
							JoinCommand joinCommand,
							MidCheckCommand midCheckCommand) {
		super();
		this.sqlSession = sqlSession;
		this.loginCommand = loginCommand;
		this.joinCommand = joinCommand;
		this.midCheckCommand = midCheckCommand;
		
	}
	
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	// login.jsp 단순이동
	@GetMapping(value="loginPage.do")
	public String loginPage() {
		return "member/login";
	}
	// 로그인(login)
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	// join.jsp 단순이동
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "member/join";
	}
	// 아이디 중복체크(mIdCheck) 
	@ResponseBody
	@GetMapping(value="mIdCheck.do", produces="application/json; charset=utf-8")
	public Map<String, Integer> idCheck(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		return midCheckCommand.execute(sqlSession, model);
	}
	// 회원가입(join)
	@PostMapping(value="join.do")
	public void join(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		joinCommand.execute(sqlSession, model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

