package com.koreait.test.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.test.command.member.EmailAuthCommand;
import com.koreait.test.command.member.IdCheckCommand;
import com.koreait.test.command.member.LoginCommand;

@Controller
public class MemberController {

	// field
	private SqlSession sqlSession;
	private LoginCommand loginCommand;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	
	
	// constructor
	@Autowired
	public MemberController(SqlSession sqlSession,
							LoginCommand loginCommand,
							IdCheckCommand idCheckCommand,
							EmailAuthCommand emailAuthCommand) {
		super();
		this.sqlSession = sqlSession;
		this.loginCommand = loginCommand;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
	}
	
	// method
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	// loginPage 단순이동
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
	// joinPage 단순이동
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "member/join";
	}
	// 아이디 중복체크(idCheck) 
	@ResponseBody
	@GetMapping(value="idCheck.do", produces="application/json; charset=utf-8")
	public Map<String, Integer> idCheck(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model);
	}
	// 이메일 인증코드 받기(emailCode)
	@ResponseBody
	@GetMapping(value="emailCode.do", produces="application/json; charset=utf-8")
	public Map<String, String> emailCode(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		return emailAuthCommand.execute(sqlSession, model);
	}
	// 회원가입(join)
/*	@PostMapping(value="join.do")
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		JoinComman
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

