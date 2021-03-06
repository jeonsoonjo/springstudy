package com.koreait.myproject.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.myproject.command.member.DeleteMemberCommand;
import com.koreait.myproject.command.member.EmailAuthCommand;
import com.koreait.myproject.command.member.EmailCheckCommand;
import com.koreait.myproject.command.member.FindIdCommand;
import com.koreait.myproject.command.member.FindPwCommand;
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
	private LogoutCommand logoutCommand;
	private IdCheckCommand idCheckCommand;
	private EmailCheckCommand emailCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private PresentPwCheckCommand presentPwCheckCommand;
	private UpdatePwCommand updatePwCommand;
	private UpdateMemberCommand updateMemberCommand;
	private DeleteMemberCommand deleteMemberCommand;
	private FindIdCommand findIdCommand;
	private FindPwCommand findPwCommand;
	
	// constructor
	@Autowired
	public MemberController(SqlSession sqlSession,
							LoginCommand loginCommand,
							IdCheckCommand idCheckCommand,
							EmailAuthCommand emailAuthCommand,
							EmailCheckCommand emailCheckCommand,
							JoinCommand joinCommand,
							PresentPwCheckCommand presentPwCheckCommand,
							UpdatePwCommand updatePwCommand,
							UpdateMemberCommand updateMemberCommand,
							LogoutCommand logoutCommand,
							DeleteMemberCommand deleteMemberCommand,
							FindIdCommand findIdCommand,
							FindPwCommand findPwCommand) {
		super();
		this.sqlSession = sqlSession;
		this.loginCommand = loginCommand;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.emailCheckCommand = emailCheckCommand;
		this.joinCommand = joinCommand;
		this.presentPwCheckCommand = presentPwCheckCommand;
		this.updatePwCommand = updatePwCommand;
		this.updateMemberCommand = updateMemberCommand;
		this.logoutCommand = logoutCommand;
		this.deleteMemberCommand = deleteMemberCommand;
		this.findIdCommand = findIdCommand;
		this.findPwCommand = findPwCommand;
	}
	
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	// myPage ????????????
	@GetMapping(value="myPage.do")
	public String myPage() {
		return "member/myPage";
	}
	// ?????????(login)
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "redirect:myPage.do";		
	}
	// ????????????(logout)
	@GetMapping(value="logout.do")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("session", session);
		logoutCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	// joinPage ????????????
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "member/join";
	}
	// ????????? ????????????(idCheck) 
	@ResponseBody
	@GetMapping(value="idCheck.do", produces="application/json; charset=utf-8")
	public Map<String, Integer> idCheck(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model);
	}
	// ????????? ????????????(emailCheck) 
	@ResponseBody
	@GetMapping(value="emailCheck.do", produces="application/json; charset=utf-8")
	public Map<String, Integer> emailCheck(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		return emailCheckCommand.execute(sqlSession, model);
	}
	// ????????? ???????????? ??????(emailCode)
	@ResponseBody
	@GetMapping(value="emailCode.do", produces="application/json; charset=utf-8")
	public Map<String, String> emailCode(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		return emailAuthCommand.execute(sqlSession, model);
	}
	// ????????????(join)
	@PostMapping(value="join.do")
	public void join(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		joinCommand.execute(sqlSession, model);
	}
	// ?????? ???????????? ??????(presentPwCheck)
	@ResponseBody
	@PostMapping(value="presentPwCheck.do", produces="application/json; charset=utf-8")
	public Map<String, Boolean> presentPwCheck(@RequestBody MemberDTO memberDTO, HttpSession session, Model model){
		model.addAttribute("session", session);
		model.addAttribute("memberDTO", memberDTO);
		return presentPwCheckCommand.execute(sqlSession, model); // sqlSession ????????? ?????? ????????? ???
	}
	// ???????????? ??????(updatePw)
	@PostMapping(value="updatePw.do")
	public void updatePw(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		updatePwCommand.execute(sqlSession, model);
	}
	// ?????? ?????? ??????(??????, ????????????, ??????)
	@PostMapping(value="updateMember.do")
	public void updateMember(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		updateMemberCommand.execute(sqlSession, model);
	}
	// ????????????(deleteMember)
	@GetMapping(value="deleteMember.do")
	public void deleteMember(HttpSession session, HttpServletResponse response, Model model) {
		model.addAttribute("session", session);
		model.addAttribute("response", response);
		deleteMemberCommand.execute(sqlSession, model);	
	}
	// findIdPage ????????????
	@GetMapping(value="findIdPage.do")
	public String findIdPage() {
		return "member/findId";
	}
	// ????????? ??????(findId)
	@PostMapping(value="findId.do")
	public String findId(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		findIdCommand.execute(sqlSession, model);
		return "member/findIdResult";
	}
	// findPwPage ????????????
	@GetMapping(value="findPwPage.do")
	public String findPwPage() {
		return "member/findPw";
	}
	// changePw ????????????
	@GetMapping(value="changePwPage.do") // ??????????????? ????????? ??????
	public String changePwPage(@ModelAttribute("email") String email) {
		return "member/changePw";
	}
	// ???????????? ??????&??????(changePw)
	@PostMapping(value="changePw.do")
	public void changePw(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		findPwCommand.execute(sqlSession, model);
	}
	
}

