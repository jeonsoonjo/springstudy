package com.koreait.myproject.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.myproject.command.member.EmailAuthCommand;
import com.koreait.myproject.command.member.IdCheckCommand;
import com.koreait.myproject.command.member.JoinCommand;
import com.koreait.myproject.command.member.LoginCommand;
import com.koreait.myproject.command.member.LogoutCommand;
import com.koreait.myproject.command.member.PresentPwCheckCommand;
import com.koreait.myproject.command.member.UpdateMemberCommand;
import com.koreait.myproject.command.member.UpdatePwCommand;
import com.koreait.myproject.dto.MemberDTO;

@Controller
public class MemberController {

	// field
	private SqlSession sqlSession;
	private LoginCommand loginCommand;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private PresentPwCheckCommand presentPwCheckCommand;
	private UpdatePwCommand updatePwCommand;
	private UpdateMemberCommand updateMemberCommand;
	private LogoutCommand logoutCommand;
	
	// constructor
	@Autowired
	public MemberController(SqlSession sqlSession,
							LoginCommand loginCommand,
							IdCheckCommand idCheckCommand,
							EmailAuthCommand emailAuthCommand,
							JoinCommand joinCommand,
							PresentPwCheckCommand presentPwCheckCommand,
							UpdatePwCommand updatePwCommand,
							UpdateMemberCommand updateMemberCommand,
							LogoutCommand logoutCommand) {
		super();
		this.sqlSession = sqlSession;
		this.loginCommand = loginCommand;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.presentPwCheckCommand = presentPwCheckCommand;
		this.updatePwCommand = updatePwCommand;
		this.updateMemberCommand = updateMemberCommand;
		this.logoutCommand = logoutCommand;
	}
	
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	// 로그인(login)
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "member/myPage";
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
	@PostMapping(value="join.do")
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		joinCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	// 현재 비밀번호 체크(presentPwCheck)
	@ResponseBody
	@PostMapping(value="presentPwCheck.do", produces="application/json; charset=utf-8")
	public Map<String, Boolean> presentPwCheck(@RequestBody MemberDTO memberDTO, HttpSession session, Model model){
		model.addAttribute("session", session);
		model.addAttribute("memberDTO", memberDTO);
		return presentPwCheckCommand.execute(sqlSession, model);
	}
	// 비밀번호 변경(updatePw)
	@PostMapping(value="updatePw.do")
	public String updatePw(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		updatePwCommand.execute(sqlSession, model);
		return index();
	}
	// 회원 정보 변경(이름, 전화번호, 주소)
	@PostMapping(value="updateMember.do")
	public String updateMember(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		updateMemberCommand.execute(sqlSession, model);
		return index();
	}
	@GetMapping(value="logout.do")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("session", session);
		logoutCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
}

