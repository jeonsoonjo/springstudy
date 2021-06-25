package com.koreait.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.member.command.EmailAuthCommand;
import com.koreait.member.command.IdCheckCommand;
import com.koreait.member.command.JoinCommand;
import com.koreait.member.command.LeaveCommand;
import com.koreait.member.command.LoginCommand;
import com.koreait.member.command.LogoutCommand;
import com.koreait.member.command.UpdateMemberCommand;

@Controller
public class MemberController {

	// field
	private SqlSession sqlSession;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private LoginCommand loginCommand;
	private LogoutCommand logoutCommand;
	private LeaveCommand leaveCommand;
	private UpdateMemberCommand updateMemberCommand;
	
	// constructor
	@Autowired
	public MemberController(SqlSession sqlSession,
							IdCheckCommand idCheckCommand,
							EmailAuthCommand emailAuthCommand,
							JoinCommand joinCommand,
							LoginCommand loginCommand,
							LogoutCommand logoutCommand,
							LeaveCommand leaveCommand,
							UpdateMemberCommand updateMemberCommand) {
		super();
		this.sqlSession = sqlSession;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.loginCommand = loginCommand;
		this.logoutCommand = logoutCommand;
		this.leaveCommand = leaveCommand;
		this.updateMemberCommand = updateMemberCommand;
	}
	
	// method
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "member/join";
	}
	
	@GetMapping(value="idCheck.do",
			produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> idCheck(HttpServletRequest request,
						  				Model model) {
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="verifyNum.do",
			produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> verifyNum(HttpServletRequest request, 
						  				 Model model) {
		model.addAttribute("request", request);
		return emailAuthCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="join.do")
	public String join(HttpServletRequest request,
					   Model model) {
		model.addAttribute("request", request);
		joinCommand.execute(sqlSession, model);
		return "redirect:/";  // return index();
	}
	
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request,
						Model model) {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@GetMapping(value="logout.do")
	public String logout(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		logoutCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@GetMapping(value="leave.do")
	public String leave(HttpSession session,
						Model model) {
		model.addAttribute("session", session);
		leaveCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@GetMapping(value="myPage.do")
	public String myPage(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		return "member/myPage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

